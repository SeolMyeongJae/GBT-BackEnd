var challenge = {
  init: () => {
    var _this = this;
    $("#btn-save").on("click", () => {
      _this.save();
    });
  },

  save: () => {
    var data = {
      title: $("#title").val(),
      summary: $("#summary").val(),
      description: $("#description").val(),
      startDate: $("#startDate").val(),
      endDate: $("#endDate").val(),
      method: $("#method").val(),
      frequency: $("#frequency").val(),
      max: $("#max").val(),
      img: "코드 바꿔야함"
    };

    $.ajax({
      type: "POST",
      url: "http://54.219.40.82/api/challenge",
      dataType: "json",
      contentType: "application/json; charset=utf-8",
      data: JSON.stringify(data)
    }).done(() => {
      alert("등록되었습니다");
      window.location.href = "/api/admin/challenge";
    });
  }
};
