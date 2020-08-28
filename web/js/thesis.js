

var thesisId;
function saveThesis() {
    var thesisTitle = $("#inputThesisTitle").val();
    var studentId = $("#inputStudentId").val();
    var thesisExamDate = $("#inputThesisExamDate").val();
    var finalResults = $("#inputFinalResults").val();
    var remarks = $("#inputRemarks").val();
    $.ajax({
        type: "POST",
        url: "ThesisController",
        data: {
            action: "add",
            thesisTitle: thesisTitle,
            studentId: studentId,
            thesisExamDate: thesisExamDate,
            finalResults: finalResults,
            remarks: remarks
        },
        success: function (data, textStatus, jqXHR) {
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function showData() {
    $("#submitBtn").val("Add New Thesis");
    $.ajax({
        url: "ThesisController",
        method: "POST",
        async: false,
        data: {
            action: "view"
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].thesisTitle + "</td>";
                html += "<td >" + data[i].student.studentId + "</td>";
                html += "<td >" + data[i].thesisExamDate + "</td>";
                html += "<td >" + data[i].finalResults + "</td>";
                html += "<td >" + data[i].remarks + "</td>";
                html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].thesisId + ");'><i class='fas fa-pencil-alt'></i></a>";
                html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].thesisId + ");'><i class='fas fa-trash'></i></a>";
                html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}
function getData(id) {
    thesisId = id;
    $.ajax({
        url: "ThesisController",
        method: "POST",
        async: false,
        data: {
            action : "getThesisRecord",
            thesisId : thesisId
        },
        success: function (data) {
            var data = JSON.parse(data);
            $("#inputThesisTitle").val(data.thesisTitle);
            $("#inputStudentId").val(data.student.studentId);
            $("#inputThesisExamDate").val(data.thesisExamDate);
            $("#inputFinalResults").val(data.finalResults);
            $("#inputRemarks").val(data.remarks);
            $("#submitBtn").val("Update Thesis");
            $("html").animate({scrollTop: 0}, "slow");
        },
        error: function(data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function updateData() {
    var thesisTitle = $("#inputThesisTitle").val();
    var studentId = $("#inputStudentId").val();
    var thesisExamDate = $("#inputThesisExamDate").val();
    var finalResults = $("#inputFinalResults").val();
    var remarks = $("#inputRemarks").val();
    var id = thesisId;
    $.ajax({
        type: "POST",
        url: "ThesisController",
        data: {
            action: "update",
            thesisTitle: thesisTitle,
            studentId: studentId,
            thesisExamDate: thesisExamDate,
            finalResults: finalResults,
            remarks: remarks,
            thesisId: id
        },
        success: function (data, textStatus, jqXHR) {
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function deleteData(id) {
    thesisId = id;
    $.ajax({
        type: "POST",
        url: "ThesisController",
        data: {
            action: "delete",
            thesisId: thesisId
        },
        success: function (data, textStatus, jqXHR) {
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            location.reload();
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
$(document).ready(function () {
    showData();
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false
        });
    });
    $("#thesisForm").validate({
        rules: {
            thesisTitle: {
                required: true
            },
            studentId: {
                required: true
            }
        },
        messages: {
            thesisTitle: {
                required: "Please Enter Thesis Title"
            },
            studentId: {
                required: "Please Enter Student ID"
            }
            
        },
        errorElement: 'span',
        errorPlacement: function (error, element) {
            error.addClass('invalid-feedback');
            element.closest('.form-group').append(error);
        },
        highlight: function (element, errorClass, validClass) {
            $(element).addClass('is-invalid');
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).removeClass('is-invalid');
        }
    });
});
$("#submitBtn").on("click", function() {
    if($("#thesisForm").valid()) {
        if($("#submitBtn").val() === "Add New Thesis") {
            saveThesis();
        }
        else if($("#submitBtn").val() === "Update Thesis"){
            updateData();
        }
    }
});
if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}

