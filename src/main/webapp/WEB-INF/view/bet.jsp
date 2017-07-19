<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="imports.jsp"></jsp:include>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div id="wrapper">
		<jsp:include page="navigation.jsp"/>
		
		<div id="page-wrapper">
	
	            <div class="container-fluid">
	
	                <!-- Page Heading -->
	                <div class="row">
	                    <div class="col-lg-12">
	                        <h1 class="page-header">
	                            Bet <small>betting area</small>
	                        </h1>
	                        <ol class="breadcrumb">
	                            <li class="active">
	                                <i class="fa fa-line-chart"></i> Bet
	                            </li>
	                        </ol>
	                    </div>
	                </div>
	
	                <!-- /.row -->
	                <div class="row">
	                    <div class="col-lg-4 col-md-6">
	                        <div class="panel panel-green">
	                            <div class="panel-heading">
	                                <div class="row">
	                                    <div class="col-xs-3">
	                                        <i class="fa fa-bank fa-5x"></i>
	                                    </div>
	                                    <div class="col-xs-9 text-right">
	                                        <div class="balance huge">${user.getBalanceBTC()}</div>
	                                        <div>Balance</div>
	                                    </div>
	                                </div>
	                            </div>
	                            <a href="#">
	                                <div class="panel-footer">
	                                    <span class="pull-left">View Details</span>
	                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                                    <div class="clearfix"></div>
	                                </div>
	                            </a>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-md-6">
	                        <div class="panel panel-primary">
	                            <div class="panel-heading">
	                                <div class="row">
	                                    <div class="col-xs-3">
	                                        <i class="fa fa-btc fa-5x"></i>
	                                    </div>
	                                    <div class="col-xs-9 text-right">
	                                        <div class="huge">${user.getWithdrawBTC()}</div>
	                                        <div>Withdraw</div>
	                                    </div>
	                                </div>
	                            </div>
	                            <a href="#">
	                                <div class="panel-footer">
	                                    <span class="pull-left">View Details</span>
	                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                                    <div class="clearfix"></div>
	                                </div>
	                            </a>
	                        </div>
	                    </div>
	                    <div class="col-lg-4 col-md-6">
	                        <div class="panel panel-red">
	                            <div class="panel-heading">
	                                <div class="row">
	                                    <div class="col-xs-3">
	                                        <i class="fa fa-support fa-5x"></i>
	                                    </div>
	                                    <div class="col-xs-9 text-right">
	                                        <div class="huge">13</div>
	                                        <div>Support Tickets!</div>
	                                    </div>
	                                </div>
	                            </div>
	                            <a href="#">
	                                <div class="panel-footer">
	                                    <span class="pull-left">View Details</span>
	                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
	                                    <div class="clearfix"></div>
	                                </div>
	                            </a>
	                        </div>
	                    </div>
	                </div>
	                <!-- /.row -->
	
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default bet-area">
								<div class="panel-body">
									<div class="row">
										<div class="col-md-6">																					
											<div class="input-group2">	
												<label>Bet Amount</label>												
												<input type="text" value="0" class="amount form-control"/>	
												<div class="btn-group btn-group-justified">
													<div class="btn-group">
														<button class="half btn btn-primary">1/2</button>
													</div>
													<div class="btn-group ">
														<button class="double btn btn-primary">2X</button>
													</div>
													<div class="btn-group">
														<button class="max btn btn-primary">MAX</button>
													</div>
												</div>									
											</div>																					
										</div>
										<div class="col-md-6">																					
											<div class="input-group2">	
												<label>Profit on Won</label>											
												<input type="text" value="0" class="form-control profit">											
											</div>	
										</div>
										
										<div class="col-md-12">
											<div class="row chance-win">
												<div class="col-md-4">
													<div class="box roll-range">
														<label>Roll Under</label>
														<div>
															<span class="value">49.50</span>
														</div>
													</div>													
												</div>
												<div class="col-md-4">
													<div class="box payout">
														<label>Payout</label>
														<div class="box-input">
															<input class="form-control" type="number" value="2" min="1.0102" max="9900" step="0.5"/>
														</div>
														<div class="box-text">
															<span class="value">2.000x</span><i class="fa fa-fw fa-edit"></i>
														</div>
													</div>													
												</div>
												<div class="col-md-4">
													<div class="box chance">
														<label>Win Chance</label>
														<div class="box-input">
															<input class="form-control" type="number" value="49.5" min="0.01" max="98" step="0.5" /><i class="fa fa-percent"></i>
														</div>
														<div class="box-text">
															<span class="value">49.50%</span><i class="fa fa-fw fa-edit"></i>
														</div>
													</div>													
												</div>
											</div>
										</div>
									</div>
								</div>
								<p style="color:red;text-align:center" class="error"></p>
								<center><button class="roll-dice btn btn-lg btn-primary">Roll Dice</button></center>								
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-body">
	                                <div id="flot"></div>
	                            </div>
								<table class="table table-hover">
									<thead>
										<tr>
											<th>Bet ID</th>
											<th>Date</th>
											<th>Amount</th>
											<th>Payout</th>
											<th>Chance</th>
											<th>Roll</th>
											<th>Profit</th>
										</tr>
									</thead>									
									<tbody id="table-body">
									</tbody>									
								</table>
							</div>
						</div>
					</div>
	                
	
	            </div>
	            <!-- /.container-fluid -->
	
	        </div>        
	        <!-- /#page-wrapper -->
	        
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
    <!-- Earn Free BTC -->
    <script src="js/freebitcoin.js"></script>
    
     <script src="js/plugins/flot/excanvas.min.js"></script>
     <script src="js/plugins/flot/jquery.flot.tooltip.min.js"></script>      
     <script src="js/plugins/flot/jquery.flot.js"></script>
     <script src="js/plugins/flot/jquery.flot.resize.js"></script>
     <script src="js/bet-system.js"></script>
     <script src="js/navigation.js"></script>
     <script>
     	document.getElementsByClassName("side-nav")[0].getElementsByTagName("li")[1].setAttribute("class","active");
     </script>
</body>
</html>