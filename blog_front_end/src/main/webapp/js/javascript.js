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