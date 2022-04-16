var uploadFiles = [];
var challenge = {
  init: function () {
    var _this = this;
    $("#btn-save").on("click", function ()  {
      _this.save();
    });

    $("#btn-update").on("click", function () {
      _this.update();
    })

    $("#btn-delete").on("click", function () {
      _this.delete();
    })

    $(document).ready(function () {
            var reader = new FileReader();
            var fileList = [];
            $("#fileInput").on("change", (e) => {
              var filename = e.target.files[0].name;
              var file = e.target.files[0];
              fileList.push(filename);
              reader.onload = (e) => {
                var img = document.createElement("img");
                img.setAttribute("src", e.target.result);
                img.setAttribute("style", "width: 150px; height: 150px;");
                img.setAttribute("class", "auto");
                document.querySelector("div#image_container").appendChild(img);
                uploadFiles.push(file);
              };
              reader.readAsDataURL(file);
              $("#userfile").val(fileList.join(', '));
            });
          });
    },
  save: function () {
      var form = new FormData($("#input-form")[0]);
      for(var file of uploadFiles) {
        form.append('img', file, file.name);
      }
//      var data = {
//        title: $("#title").val(),
//        summary: $("#summary").val(),
//        description: $("#description").val(),
//        startDate: $("#startDate").val(),
//        endDate: $("#endDate").val(),
//        method: $("#method").val(),
//        frequency: $("#frequency").val(),
//        max: $("#max").val(),
//        img: uploadFiles
//      };
      for(var value of form.entries()) {console.log(value)}
      $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/challenge",
        dataType: "json",
        data: form,
        contentType: false,
        processData: false
      }).done(() => {
        alert("등록되었습니다");
//        window.location.href = "/api/admin/challenge";
      }).fail(function (error) {
         alert(JSON.stringify(error));
      });
    },

  update: function () {
    var form = new FormData($("#input-form")[0]);
    var path = location.pathname.split("/");
    var id = path[path.length - 1];
    for(var file of uploadFiles) {
      form.append('img', file, file.name);
    }
    for(var value of form.entries()) {console.log(value)}
          $.ajax({
            type: "PUT",
            url: `http://localhost:8080/api/challenge/${id}`,
            dataType: "json",
            data: form,
            contentType: false,
            processData: false
          }).done(() => {
            alert("수정되었습니다");
    //        window.location.href = "/api/admin/challenge";
          }).fail(function (error) {
             alert(JSON.stringify(error));
          });
  },

  delete: function () {
    var path = location.pathname.split("/");
    var id = path[path.length - 1];
    $.ajax({
      type: "DELETE",
      url: `http://localhost:8080/api/challenge/${id}`,
      dataType: "json",
      contentType: "aplictaion/json; charset=utf-8"
    }).done(function() {
      alert('글이 삭제되었습니다');
      window.location.href = '/api/admin/challenge'
    }).fail(function (error) {
      alert(JSON.stringify(error));
    })
  }
};

challenge.init();
