function summerImageUpload(selector, files){
	var formData = new FormData();
	formData.append("files", files[0]);
    $.ajax({
        url: '/imageUpload.ajax',
        processData: false,
        contentType: false,
        data: formData,
        type: 'POST',
        success: function(result){
            //alert(window.location.origin + ":" + result);
            // 테스트
          	var imgUrl = "https://summernote.org/img/img_gnb_twitter.png";
			var image = $('<img>').attr("src", imgUrl);
			alert(image + ":" + image[0]);
			$(selector).summernote("insertNode", image[0]);
			// 테스트 end
        }
	});
}