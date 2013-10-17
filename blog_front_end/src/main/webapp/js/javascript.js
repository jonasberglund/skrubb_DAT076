/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


 function showHide(shID) {
	if (document.getElementById(shID)) {
		if (document.getElementById(shID+'-show').style.display !== 'none') {
			document.getElementById(shID+'-show').style.display = 'none';
			document.getElementById(shID).style.display = 'block';
		}
		else {
			document.getElementById(shID+'-show').style.display = 'inline';
			document.getElementById(shID).style.display = 'none';
		}
	}
}


$(function(){
   $('#comments').click(function(){
      var commentSection =$(this).parent('article').find('#commentSection');
      if(commentSection.hasClass('hidden'))
          commentSection.removeClass('hidden');
      else
          commentSection.addClass('hidden');
   });
});

function setCommenter(id) {
    var field = document.getElementById('commenter'+id);
    var hiddenField = document.getElementById('addCommentForm:commenter');
    var postIdField = document.getElementById('addCommentForm:postId');
    postIdField.value = id;
    hiddenField.value = field.value;
}
function setCommentValue(id) {
    var field = document.getElementById('value'+id);
    var hiddenField = document.getElementById('addCommentForm:value');
    var postIdField = document.getElementById('addCommentForm:postId');
    postIdField.value = id;
    hiddenField.value = field.value;
}