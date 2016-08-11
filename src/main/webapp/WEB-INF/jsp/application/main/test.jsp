<%@page info="main"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--======================================================================================================
'시 스 템 : 
'프로그램 ID : application/main.jsp
'프로그램 명 : 요약 페이지
'프로그램개요 : 
'작 성 자 : 
'작 성 일 :
==========================================================================================================
'수정자/수정일 : 
'수정사유/내역 : 
==========================================================================================================
--%>
<script src="${pageContext.request.contextPath}/resources/js/application/error/page.access.error.js"></script>
<section id="widget-grid" class="">

<h2>테스트페이지</h2>
	<!-- row -->
	<!-- <div class="row">
		<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<div class="jarviswidget jarviswidget-color-darken" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-deletebutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-table"></i> </span>
					<h2><a href="javascript:void(0);" class="dashboard_lnk" onclick="f_lnkSysNoti();"></a></h2>				
				</header>
				<div>
					<div class="jarviswidget-editbox">
						<input class="form-control" type="text">	
					</div>
					<div class="widget-body no-padding">
						<div class="table-responsive">
							<table class="table table-bordered">
								<colgroup>
									<col width="*" />
									<col width="10%" />
								</colgroup>
								<tbody id="layer_dash_sysnoti">
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</article>
	</div>
	
	<div class="row">
		
		<article class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<div class="jarviswidget jarviswidget-color-darken" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-deletebutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
					<h2><a href="javascript:void(0);" class="dashboard_lnk" onclick="f_lnkStatsMbrSignup()"></a></h2>				
				</header>
				<div>
					<div class="jarviswidget-editbox">
						<input class="form-control" type="text">	
					</div>
					widget content
					<div class="widget-body">
						<div class="text-right" id="member_signup_header">&nbsp;기준</div>
						<canvas id="member_signup_chart" height="120"></canvas>
						<div id="member_signup_chart_legend"></div>
					</div>
				</div>
			</div>
		</article>
		
		<article class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
			<div class="jarviswidget jarviswidget-color-darken" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-deletebutton="false">
				<header>
					<span class="widget-icon"> <i class="fa fa-bar-chart-o"></i> </span>
					<h2><a href="javascript:void(0);" class="dashboard_lnk" onclick="f_lnkStatsCprcomPmt()"></a></h2>				
				</header>
				<div>
					<div class="jarviswidget-editbox">
						<input class="form-control" type="text">	
					</div>
					widget content
					<div class="widget-body">
						<div class="text-right" id="payment_chart_header">&nbsp;기준</div>
						<canvas id="payment_chart" height="120"></canvas>
						<div id="payment_chart_legend"></div>
					</div>
				</div>
			</div>
		</article>
	</div> -->
</section>
<!-- end widget grid -->
<script type="text/javascript">
/**
 * ==================================================================================
 * 페이지 정보 설정
 * ----------------------------------------------------------------------------------
 * 초기 설정 및 필요 UI 컴포넌트 셋팅
 * ==================================================================================
 */
/* var dashboard_pagefunction = function() {
	f_loadDashboardNoti();
	
	f_loadDashboardSignUp();
	
	f_loadDashboardPayment();
	
	// 기준월
	/* var today = cf_toDate();
	$('#member_signup_header').prepend(cf_termDate(-1, today));
	$('#payment_chart_header').prepend(cf_termDate(-1, today)); 
}; */


/**
 * ==================================================================================
 * 페이지 셋업 (don't remove!)
 * ----------------------------------------------------------------------------------
 * 기본 페이지 사용 컴포넌트 호출 및 초기화 작업 진행
 * ==================================================================================
 */
//pageSetUp();


/**
 * ==================================================================================
 * 페이지 정보 설정 로드
 * ----------------------------------------------------------------------------------
 * 컴포넌트 SCRIPT 파일 로드 및 페이지 정보 설정 SCRIPT 로드
 * ==================================================================================
 */
// loadScript("${pageContext.request.contextPath}/resources/js/plugin/chartjs/chart.min.js", dashboard_pagefunction);


/**
 * ==================================================================================
 * 페이지 정보 설정 초기화
 * ----------------------------------------------------------------------------------
 * 컴포넌트 설정 초기화 SCRIPT 로드
 * ==================================================================================
 */
/* var pagedestroy = function(){
	memberSignupChart.destroy();
	memberSignupChart = null;
	
	paymentChart.destroy();
	paymentChart = null;
};

_startBlockEvent(); */
</script>
