/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var feesId;
function saveFees() {
    var feesTitle = $("#inputFeesTitle").val();
    var amount = $("#inputAmount").val();
    var announcementDate = $("#inputAnnouncementDate").val();
    var dueDate = $("#inputDueDate").val();
    $.ajax({
        type: "POST",
        url: "FeesController",
        data: {
            action: "add",
            feesTitle: feesTitle,
            amount: amount,
            announcementDate: announcementDate,
            dueDate: dueDate
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            alert("Data Added Successfully!");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });

    //}

}
function showData() {
    $("#submitBtn").val("Add New Fees");
    $.ajax({
        url: "FeesController",
        method: "POST",
        async: false,
        data: {
            action: "view"
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "";
            for (var i = 0; i < data.length; i++) {
                html += "<tr><td >" + data[i].feesTitle + "</td>";
                html += "<td >" + data[i].amount + "</td>";
                html += "<td >" + data[i].announcementDate + "</td>";
                html += "<td >" + data[i].dueDate + "</td>";
                html += "<td class='text-center py-0 align-middle'><div class='btn-group btn-group-sm'>";
                html += "<a type='button' class='btn btn-info' onclick='getData(" + data[i].feesId + ");'><i class='fas fa-pencil-alt'></i></a>";
                html += "<a type='button' class='btn btn-danger' onclick='deleteData(" + data[i].feesId + ");'><i class='fas fa-trash'></i></a>";
                html += "</div></td>";
                html += "</tr>";
            }
            $("#tab").html(html);
        }
    });
}
function getData(id) {
    feesId = id;
    $.ajax({
        url: "FeesController",
        method: "POST",
        async: false,
        data: {
            action : "getFeesRecord",
            feesId : feesId
        },
        success: function (data) {
            var data = JSON.parse(data);
            $("#inputFeesTitle").val(data.feesTitle);
            $("#inputAmount").val(data.amount);
            $("#inputAnnouncementDate").val(data.announcementDate);
            $("#inputDueDate").val(data.dueDate);
            $("#submitBtn").val("Update Fees");
            $("html").animate({scrollTop: 0}, "slow");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function updateData() {
    var feesTitle = $("#inputFeesTitle").val();
    var amount = $("#inputAmount").val();
    var announcementDate = $("#inputAnnouncementDate").val();
    var dueDate = $("#inputDueDate").val();
    var id = feesId;
    $.ajax({
        type: "POST",
        url: "FeesController",
        data: {
            action: "update",
            feesTitle: feesTitle,
            amount: amount,
            announcementDate: announcementDate,
            dueDate : dueDate,
            feesId: id
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            alert("Data Updated Successfully!");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function deleteData(id) {
    feesId = id;
    $.ajax({
        type: "POST",
        url: "FeesController",
        data: {
            action: "delete",
            feesId: feesId
        },
        success: function (data, textStatus, jqXHR) {
            resetFields();
            showData();
            location.reload();
            $("html").animate({scrollTop: $(document).height()}, 1000);
            alert("Data Deleted Successfully!");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function populateFaculties() {
    $.ajax({
        url: "FacultyController",
        method: "POST",
        async: false,
        data: {
            action: "view"
        },
        success: function (data) {
            var data = JSON.parse(data);
            var html = "<option value='' selected disabled>Select Faculty</option>";
            for (var i = 0; i < data.length; i++) {
                html += "<option value='" + data[i].facultyId + "'>" + data[i].facultyName + "</option>";
            }
            $("#inputFaculty").html(html);
        }
    });
}
function resetFields() {
    $("#inputDepartment").val('');
    $("#inputFaculty").val('1');
    showData();
    populateFaculties();
}
$(document).ready(function () {
    showData();
    populateFaculties();
    $(function () {
        $("#example1").DataTable({
            "responsive": true,
            "autoWidth": false
        });
    });
    $("#departmentForm").validate({
        rules: {
            feesTitle: {
                required: true
            },
            amount: {
                required: true
            },
            announcementDate: {
                required: true
            },
            dueDate: {
                required: true
            }
        },
        messages: {
            feesTitle: {
                required: "Please Enter Fees Title"
            },
            amount: {
                required: "Please Enter Amount"
            },
            announcementDate: {
                required: "Please select Announcement Date"
            },
            dueDate: {
                required: "Please Select Due Date"
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
$("#submitBtn").on("click", function () {
    if ($("#feesForm").valid()) {
        if ($("#submitBtn").val() === "Add New Fees") {
            saveFees();
        } else if ($("#submitBtn").val() === "Update Fees") {
            alert("updateCalled");
            updateData();
        }
    }
});
if (window.history.replaceState) {
    window.history.replaceState(null, null, window.location.href);
}
