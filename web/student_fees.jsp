<%-- 
    Document   : student_fees
    Created on : Aug 21, 2020, 4:52:41 PM
    Author     : khatr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fees Details</title>
        <jsp:include page="head_links.jsp"/>
        <style>
            .fa-pencil-alt {
                color: white;
            }
            .fa-trash {
                color: white;
            }
        </style>
    </head>
    <body class="hold-transition sidebar-mini">
        <!-- Site wrapper -->
        <div class="wrapper">
            <jsp:include page="student_navbar.jsp"/>
            <jsp:include page="student_topnavbar.jsp"/>
            <%
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                response.setHeader("pragma", "no-cache");
                response.setHeader("Expires", "0");
                if (session.getAttribute("student") != null) {
            %>
            <input type="hidden" id="studentSessionId" value="${sessionScope.student.studentId}"/>
            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Fees Details</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="student_dashboard.jsp">Home</a></li>
                                    <li class="breadcrumb-item active">Fees</li>
                                </ol>
                            </div>
                        </div>
                    </div><!-- /.container-fluid -->
                </section> 
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-md-12">
<!--                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Add Batch</h3>

                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                            <i class="fas fa-minus"></i></button>
                                    </div>
                                </div>
                                <form id="batchForm" method="POST">
                                    <div class="card-body">
                                        <div class="form-group">
                                            <label for="inputBatch">Batch Name</label>
                                            <input name="batchName" type="text" id="inputBatch" class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <input id="submitBtn" type="submit" value="Add New Batch" class="btn btn-success float-right">
                                        </div>


                                    </div>
                                     /.card-body 
                                </form>

                            </div>-->
                            <!-- /.card -->
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Fees Details</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Fees Title</th>
                                                <th>Fees Amount</th>
                                                <th>Date Announced</th>
                                                <th>Due Date</th>
                                                <th>Date Paid</th>
                                                <th>Amount Paid</th>
                                                <th>Late Fees</th>
                                                <th>Challan No</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tab">

                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Fees Title</th>
                                                <th>Fees Amount</th>
                                                <th>Date Announced</th>
                                                <th>Due Date</th>
                                                <th>Date Paid</th>
                                                <th>Amount Paid</th>
                                                <th>Late Fees</th>
                                                <th>Challan No</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>

                    </div>

                </section>
            </div>
            <!-- /.content-wrapper -->
            <%
                } else {
                    // If Session Expires

                    response.sendRedirect("login.jsp");
                }
            %>
            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->   
        </div>
        <!-- ./wrapper -->

        <jsp:include page="bottom_links.jsp"/>
        <!-- page script -->
        <script src="js/student_fees.js"></script>
    </body>
</html>
