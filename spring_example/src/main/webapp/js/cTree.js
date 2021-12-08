
// 화면 Render 시 Json Data Sample
/*
    var JSONData = [
        {
            id: 0,
            title: 'Horse'
        }, {
            id: 1,
            title: 'Birds',
            //isSelectable: false,
            subs: [
                {
                    id: 10,
                    title: 'Pigeon',
                    //isSelectable: false
                }, {
                    id: 11,
                    title: 'Parrot'
                }, {
                    id: 12,
                    title: 'Owl'
                }, {
                    id: 13,
                    title: 'Falcon'
                }
            ]
        }
    ];
*/



//comboTree 전역변수
var gComboTree;

//ComboTree 데이터 화면에 Render하는 함수
var gfnRenderComboTree = function(ids, inputData){
    	
	// 카테고리, 기기, 구성품 정비 항목 ID 에 각각 '|' 구분자로 레벨에 따라서 차례로 넣어줌.
	var replaceIdData = fnReplaceComboTreeId(inputData);

	//comboTree에 카테고리,기기, 구성품 데이터를 Tree 형태로 구성해줌.
	var JSONData = fnMakeTree(replaceIdData);
	
	
	//Tree 형태로 구성된 JSONData를 comboTree로 Render 해줌.
   	gComboTree = $(ids).comboTree({
        source : JSONData,
        isMultiple: false,
        cascadeSelect: true,
		collapse:true
    });
}



// 카테고리, 기기, 구성품 정비 항목 ID 에 각각 '|' 구분자로 레벨에 따라서 차례로 넣어줌.
var fnReplaceComboTreeId = function(inputData){
	var cateList = inputData.cateList; //카테고리
	var eqList = inputData.eqList; //장비
	var compoList = inputData.compoList; //구성품

	
	//category
	for(i=0; i < cateList.length;i++){
		cateList[i].id = cateList[i].cate_id;
		cateList[i].title = cateList[i].cate_desc;
	}
	
	//equip
	for(i=0 ;i<eqList.length;i++){
		for(j=0;j<cateList.length;j++){
			if(eqList[i].parent == cateList[j].cate_id ){
				eqList[i].id = cateList[j].id+"|"+eqList[i].eq_id;
				eqList[i].title = eqList[i].eq_desc;
			}
		}
	}
	
	//component
	for(i=0 ;i<compoList.length;i++){
		for(j=0;j<eqList.length;j++){
			if(compoList[i].parent == eqList[j].eq_id ){
				
				compoList[i].id = eqList[j].id +"|"+compoList[i].compo_id;
				compoList[i].title = compoList[i].compo_desc;
			}
		}
	}
	

	return {
		cateList : cateList,
		eqList : eqList,
		compoList : compoList
		};
}


//comboTree에 카테고리,기기, 구성품 데이터를 Tree 형태로 구성해줌.
var fnMakeTree = function(data){
	var cateList = data.cateList; //카테고리
	var eqList = data.eqList; //기기
	var compoList = data.compoList; //구성품
	
	//component
	for(i=0;i<compoList.length;i++){
		for(j=0;j<eqList.length;j++){
			if(compoList[i].parent == eqList[j].eq_id){
				
				//하위 레벨의 subData 항목이 없을 경우에만 jsonArray 를 생성함.
				//subData가 이미 있는경우에는 push 만 해줌.
				if(typeof eqList[j].subs=='undefined'){
					eqList[j].subs = [];
				}
				eqList[j].subs.push(compoList[i]);				
			}
		}
	}
	
	//equip
	for(i=0;i<eqList.length;i++){
		for(j=0;j<cateList.length;j++){
			if(eqList[i].parent == cateList[j].cate_id){
				
				//하위 레벨의 subData 항목이 없을 경우에만 jsonArray 를 생성함.
				//subData가 이미 있는경우에는 push 만 해줌.
				if(typeof cateList[j].subs=='undefined'){
					cateList[j].subs = [];
				}
				cateList[j].subs.push(eqList[i]);				
			}
		}
	}
	
	return cateList;
}


//선택한 카테고리,기기,구성품 항목의 ID 를 Return 함.
var fnReturnComboTreeVal = function(){
		
		var splitResult = {
			cateId : null,
			eqId : null,
			compoId : null
			}
		

		if(typeof gComboTree != 'undefined'){
	    	var selectedIds = gComboTree.getSelectedIds();
        	//var selectedNames = comboTree.getSelectedNames();
			splitResult = fnSplitId(selectedIds);
		}
		
		return splitResult;
}


// "|" 구분자로 구성된 ID 를 Split
var fnSplitId = function(id){
	var cateId;
	var eqId;
	var compoId;
	
	
	var strArr = id[0].split('|');
	
	if(strArr.length == 3){
		cateId = strArr[0];
		eqId = strArr[1];
		compoId = strArr[2];
	}
	else if(strArr.length == 2){
		cateId = strArr[0];
		eqId = strArr[1];
		compoId = null;
	}else{
		cateId = id[0];
		eqId = null;
		compoId = null;
	}

	return {
		cateId : cateId,
		eqId : eqId,
		compoId : compoId
	}	
}