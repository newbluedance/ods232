<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
	<head>
		<title>404错误页面</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="Content-Language" content="utf-8" />
		<style type="text/css">
			A:link {
				COLOR: #555555;
				TEXT-DECORATION: none
			}
			
			A:visited {
				COLOR: #555555;
				TEXT-DECORATION: none
			}
			
			A:active {
				COLOR: #555555;
				TEXT-DECORATION: none
			}
			
			A:hover {
				COLOR: #6f9822;
				TEXT-DECORATION: none
			}
			
			.text {
				FONT-SIZE: 12px;
				COLOR: #555555;
				FONT-FAMILY: "";
				TEXT-DECORATION: none
			}
			
			.STYLE1 {
				font-size: 13px
			}
			
			.STYLE2 {
				font-size: 12px
			}
			
			.STYLE3 {
				font-size: 11px
			}
			</style>
	</head>
	<body>
		<table height="100%" cellspacing="0" cellpadding="0" width="100%"
			align="center" border="0">

			<tbody>
				<tr>
					<td valign="center" align="middle">
						<table cellspacing="0" cellpadding="0" width="500" align="center"
							border="0">

							<tbody>
								<tr>
									<td width="17" height="17">
										<img height="17"
											src="<%=request.getContextPath()%>/images/co_01.gif"
											width="17" />
									</td>
									<td width="316"
										background="<%=request.getContextPath()%>/images/bg01.gif"></td>
									<td width="17" height="17">
										<img height="17"
											src="<%=request.getContextPath()%>/images/co_02.gif"
											width="17" />
									</td>
								</tr>
								<tr>
									<td
										background="<%=request.getContextPath()%>/images/bg02.gif"></td>
									<td>
										<table class="text" cellspacing="0" cellpadding="10"
											width="100%" align="center" border="0">
											<tbody>
												<tr>
													<td>
														<table cellspacing="0" cellpadding="0" width="100%"
															border="0">
															<tbody>
																<tr>
																	<td width="20">
																	</td>
																	<td>
																		<img height="66"
																			src="<%=request.getContextPath()%>/images/404error_cn.gif"
																			width="400" />
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
												<tr>
													<td>
														<table cellspacing="0" cellpadding="0" width="100%"
															border="0">
															<tbody>
																<tr><!-- <%=request.getContextPath()%>/images/dot_01.gif -->
																	<td	background="" height="0"></td>
																</tr>
															</tbody>
														</table>
														<br>
														<table class="text" cellspacing="0" cellpadding="0"
															width="100%" border="0">
															<tbody>
																<tr>
																	<td width="20">
																	</td>
																	<td>
																		<p>
																			<strong><font color="#ba1c1c">HTTP404错误</font>
																			</strong>:
																			<br />
																			<br />
																			没有找到您要访问的页面，请检查您是否输入正确URL。
																			<br>
																			<br />
																			请尝试以下操作：
																		</p>
																		<p>
																			・如果您已经在地址栏中输入该网页的地址，请确认其拼写正确。
																			<br />
																			・打开该站点主页，然后查找指向您感兴趣信息的链接。
																			<br>
																			・单击
																			<a href="javascript:history.back(1)"><font
																				color="#BA1C1C">后退</font> </a>链接，尝试其他链接。
																			<br />
																		</p>
																		<p align="right">
																			By：
																			<a href="http://www.ninetowns.com/" target="_blank">北京九城集团</a>&nbsp;
																		</p>
																		<div align="right"></div>
																	</td>
																</tr>
															</tbody>
														</table>
													</td>
												</tr>
											</tbody>
										</table>
									</td>
									<td
										background="<%=request.getContextPath()%>/images/bg03.gif"></td>
								</tr>
								<tr>
									<td width="17" height="17">
										<img height="17"
											src="<%=request.getContextPath()%>/images/co_03.gif"
											width="17" />
									</td>
									<td
										background="<%=request.getContextPath()%>/images/bg04.gif"
										height="17"></td>
									<td width="17" height="17">
										<img height="17"
											src="<%=request.getContextPath()%>/images/co_04.gif"
											width="17" />
									</td>
								</tr>
							</tbody>
						</table>
						<table class="text" cellspacing="0" cellpadding="0" width="500"
							align="center" border="0">
							<tbody>
								<tr>
									<td></td>
								</tr>
								<tr>
									<td align="middle"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>