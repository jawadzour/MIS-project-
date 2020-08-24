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
    var batch = $("#inputBatch").val();
    var admissionDate = $("#inputAdmissionDate").val();
    // $("#inputSupervisor").val(data[21].supervisor);
    var program = $("#inputProgram").val();
    var fieldProgram = $("#inputFieldProgram").val();
    var shift = $("#inputShift").val();
    var timing = $("#inputTiming").val();
    var departmentId=$("#inputDepartmentId").val();
    var departmentName=$("#inputDepartment").val();
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
            batch: batch,
            admissionDate: admissionDate,
            program: program,
            fieldProgram: fieldProgram,
            shift: shift,
            timing: timing,
            departmentId:departmentId,
            departmentName:departmentName
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
    var sId = $("#studentId").val();
    $.ajax({
        url: "StudentController",
        method: "POST",
        async: false,
        data: {
            action: "getStudentProfileRecord",
            id : sId
        },
        success: function (data) {
            var data = JSON.parse(data);
            alert(data.studentId);
            getId(data.studentId);
                $("#inputDepartmentId").val(data.department.departmentId);
                $("#inputFullName").val(data.fullName);
                $("#inputRollNumber").val(data.rollNumber);
                $("#inputFatherName").val(data.fathersName);
                $("#inputLegalId").val(data.legalId);
                $("#inputLegalIdNo").val(data.legalIdNo);
                $("#inputNationality").val(data.nationality);
                $("#inputPlaceOfIssueOfLegalId").val(data.placeOfIssueOfLegalId);
                $("#inputDateOfIssueOfLegalId").val(data.dateOfIssueOfLegalId);
                $("#inputMobileNumber").val(data.mobile);
                $("#inputDob").val(data.dob);
                $("#inputEmail").val(data.email);
                $("#inputDomicile").val(data.domicile);
                $("#inputCountryOfBirth").val(data.countryOfBirth);
                $("#inputBloodGroup").val(data.bloodGroup);
                $("#inputReligion").val(data.religion);
                $("#inputAddress").val(data.address);
                $("#inputCurrentAddress").val(data.currentAddress);
                $("#inputSemester").val(data.semester);
                $("#inputDepartment").val(data.department.departmentName);
                $("#inputBatch").val(data.batch);
                $("#inputAdmissionDate").val(data.admissionDate);
                // $("#inputSupervisor").val(data[21].supervisor);
                $("#inputProgram").val(data.program);
                $("#inputFieldProgram").val(data.fieldProgram);
                $("#inputShift").val(data.shift);
                $("#inputTiming").val(data.timing);
//            for (var i = 0; i < data.length; i++) {
//                
//                getId(data[i].studentId);
//                $("#inputDepartmentId").val(data[i].department.departmentId);
//                $("#inputFullName").val(data[i].fullName);
//                $("#inputRollNumber").val(data[i].rollNumber);
//                $("#inputFatherName").val(data[i].fathersName);
//                $("#inputLegalId").val(data[i].legalId);
//                $("#inputLegalIdNo").val(data[i].legalIdNo);
//                $("#inputNationality").val(data[i].nationality);
//                $("#inputPlaceOfIssueOfLegalId").val(data[i].placeOfIssueOfLegalId);
//                $("#inputDateOfIssueOfLegalId").val(data[i].dateOfIssueOfLegalId);
//                $("#inputMobileNumber").val(data[i].mobile);
//                $("#inputDob").val(data[i].dob);
//                $("#inputEmail").val(data[i].email);
//                $("#inputDomicile").val(data[i].domicile);
//                $("#inputCountryOfBirth").val(data[i].countryOfBirth);
//                $("#inputBloodGroup").val(data[i].bloodGroup);
//                $("#inputReligion").val(data[i].religion);
//                $("#inputAddress").val(data[i].address);
//                $("#inputCurrentAddress").val(data[i].currentAddress);
//                $("#inputSemester").val(data[i].semester);
//                $("#inputDepartment").val(data[i].department.departmentName);
//                $("#inputBatch").val(data[i].batch);
//                $("#inputAdmissionDate").val(data[i].admissionDate);
//                // $("#inputSupervisor").val(data[21].supervisor);
//                $("#inputProgram").val(data[i].program);
//                $("#inputFieldProgram").val(data[i].fieldProgram);
//                $("#inputShift").val(data[i].shift);
//                $("#inputTiming").val(data[i].timing);
//                
//            }


            $("html").animate({scrollTop: 0}, "slow");
        },
        error: function (data, textStatus, jqXHR) {
            alert("Error");
        }
    });
}
function getId(id) {
    studentId=id;  
}
$(document).ready(function () {
    getData();
    getId(studentId);
    $('#submitBtn1').click(function () {
        updateData();
    });
});

