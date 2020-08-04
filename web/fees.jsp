<%-- 
    Document   : fees
    Created on : Aug 4, 2020, 4:24:31 PM
    Author     : khatr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Management Information System</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

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
            <jsp:include page="navbar.jsp"/>
            <jsp:include page="top_navbar.jsp"/>

            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">
                        <div class="row mb-2">
                            <div class="col-sm-6">
                                <h1>Manage Fees</h1>
                            </div>
                            <div class="col-sm-6">
                                <ol class="breadcrumb float-sm-right">
                                    <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
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
                            <div class="card card-primary">
                                <div class="card-header">
                                    <h3 class="card-title">Add Fees</h3>

                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                            <i class="fas fa-minus"></i></button>
                                    </div>
                                </div>
                                <form id="feesForm" method="POST">
                                    <div class="card-body">
                                    <div class="form-group">
                                        <label for="inputFeesTitle">Fees Title</label>
                                        <input name="feesTitle" type="text" id="inputFeesTitle" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAmount">Amount</label>
                                        <input name="amount" type="number" id="inputAmount" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputAnnouncementDate">Announcement Date</label>
                                        <input name="announcementDate" type="datetime-local" id="inputAnnouncementDate" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDueDate">Due Date</label>
                                        <input name="dueDate" type="datetime-local" id="inputDueDate" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <input id="submitBtn" type="submit" value="Add New Fees" class="btn btn-success float-right" >
                                    </div>


                                </div>
                                <!-- /.card-body -->
                                </form>
                                
                            </div>
                            <!-- /.card -->
                            <div class="card">
                                <div class="card-header">
                                    <h3 class="card-title">Departments</h3>
                                </div>
                                <!-- /.card-header -->
                                <div class="card-body">
                                    <table id="example1" class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th>Fees Title</th>
                                                <th>Amount</th>
                                                <th>Announcement Date</th>
                                                <th>Due Date</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tab">

                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Fees Title</th>
                                                <th>Amount</th>
                                                <th>Announcement Date</th>
                                                <th>Due Date</th>
                                                <th>Action</th>
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

            <!-- Control Sidebar -->
            <aside class="control-sidebar control-sidebar-dark">
                <!-- Control sidebar content goes here -->
            </aside>
            <!-- /.control-sidebar -->   
        </div>
        <!-- ./wrapper -->

        <jsp:include page="bottom_links.jsp"/>
        <!-- page script -->
        <script src="js/fees.js"></script>
    </body>
</html>
