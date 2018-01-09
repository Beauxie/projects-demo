var treeUrl = '/treedemo/deptController/deptTree.do';
var tree = null;//表示树

$(function() {
	tree = $('#vl');
	initTree();//初始化树
	

});

function initTree() {
	 tree.tree({
		url: treeUrl,
		animate: false,
		lines : true,
		checkbox : false,//是否显示复选框
		onClick: function(node) {
			//nodeClick(node);
		},
		onLoadSuccess: function(data) {
 			alert("加载成功！");
		}
	}); 
}

