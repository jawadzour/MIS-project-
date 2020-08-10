/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var studentId;
function updateData() {
    var id = studentId;
    var fullName = $("#inputFullName").val();
    var rollNumber = $("#inputRollNumber").val();
    var fathersName = $("#inputFatherName").val();
    var legalId = $("#inputLegalId").val();
    var legalIdNo = $("#inputLegalIdNo").val();
    var nationality = $("#inputNationality").val();
    var placeOfIssueOfLegalId = $("#inputPlaceOfIssueOfLegalId").val();
    var dateOfIssueOfLegalId = $("#inputDateOfIssueOfLegalId").val();
    var mobile = $("#inputMobileNumber").val();
    var dob = $("#inputDob").val();
    var email = $("#inputEmail").val();
    var domicile = $("#inputDomicile").val();
    var countryOfBirth = $("#inputCountryOfBirth").val();
    var bloodGroup = $("#inputBloodGroup").val();
    var religion = $("#inputReligion").val();
    var address = $("#inputAddress").val();
    var currentAddress = $("#inputCurrentAddress").val();
    var semester = $("#inputSemester").val();
    var batchId = $("#inputBatch").val();
    var admissionDate = $("#inputAdmissionDate").val();
    // $("#inputSupervisor").val(data[21].supervisor);
    var program = $("#inputProgram").val();
    var fieldProgram = $("#inputFieldProgram").val();
    var shift = $("#inputShift").val();
    var timing = $("#inputTiming").val();
    $.ajax({
        type: "POST",
        url: "StudentController",
        data: {
            action: "update",
            studentId: id,
            fullName: fullName,
            rollNumber: rollNumber,
            fathersName: fathersName,
            legalId: legalId,
            legalIdNo: legalIdNo,
            nationality: nationality,
            placeOfIssueOfLegalId: placeOfIssueOfLegalId,
            dateOfIssueOfLegalId: dateOfIssueOfLegalId,
            mobile: mobile,
            dob: dob,
            email: email,
            domicile: domicile,
            countryOfBirth: countryOfBirth,
            bloodGroup: bloodGroup,
            religion: religion,
            address: address,
            currentAddress: currentAddress,
            semester: semester,
            batchId: batchId,
            admissionDate: admissionDate,
            // $("#inputSupervisor").val(data[21].supervisor);
            program: program,
            fieldProgram: fieldProgram,
            shift: shift,
            timing: timing

        }
        ,
        success: function (data, textStatus, jqXHR) {
            alert("Data is updated succesfully");
            $("html").animate({scrollTop: $(document).height()}, 1000);
        }
        ,
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    }
    );
}
function getData() {

    $.ajax({
        url: "StudentController",
        method: "POST",
        async: false,
        data: {
            action: "getStudentProfileRecord"
        },
        success: function (data) {
            var data = JSON.parse(data);

            for (var i = 0; i < data.length; i++) {
                $("#inputFullName").val(data[i].fullName);
                $("#inputRollNumber").val(data[i].rollNumber);
                $("#inputFatherName").val(data[i].fathersName);
                $("#inputLegalId").val(data[i].legalId);
                $("#inputLegalIdNo").val(data[i].legalIdNo);
                $("#inputNationality").val(data[i].nationality);
                $("#inputPlaceOfIssueOfLegalId").val(data[i].placeOfIssueOfLegalId);
                $("#inputDateOfIssueOfLegalId").val(data[i].dateOfIssueOfLegalId);
                $("#inputMobileNumber").val(data[i].mobile);
                $("#inputDob").val(data[i].dob);
                $("#inputEmail").val(data[i].email);
                $("#inputDomicile").val(data[i].domicile);
                $("#inputCountryOfBirth").val(data[i].countryOfBirth);
                $("#inputBloodGroup").val(data[i].bloodGroup);
                $("#inputReligion").val(data[i].religion);
                $("#inputAddress").val(data[i].address);
                $("#inputCurrentAddress").val(data[i].currentAddress);
                $("#inputSemester").val(data[i].semester);
                $("#inputBatch").val(data[i].batchId);
                $("#inputAdmissionDate").val(data[i].admissionDate);
                // $("#inputSupervisor").val(data[21].supervisor);
                $("#inputProgram").val(data[i].program);
                $("#inputFieldProgram").val(data[i].fieldProgram);
                $("#inputShift").val(data[i].shift);
                $("#inputTiming").val(data[i].timing);
                alert(data[i].fullName);
            }


            $("html").animate({scrollTop: 0}, "slow");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function getId(id) {
    studentId = id;
}
$(document).ready(function () {
    getData();
    $('#submitBtn1').click(function () {
        updateData();

    });
});

