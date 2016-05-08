<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>question</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/demo.css" />
	<link rel="stylesheet" type="text/css" href="css/component.css" />
	<link rel="stylesheet" type="text/css" href="css/cs-select.css" />
	<link rel="stylesheet" type="text/css" href="css/cs-skin-boxes.css" />
	<script src="js/modernizr.custom.js"></script>
</head>
<body>
	<div class="container">
		<div class="fs-form-wrap" id="fs-form-wrap">
			<div class="fs-title">
				<h1>问卷调查</h1>
			</div>
			<form id="myform" class="fs-form fs-form-full" autocomplete="off" method="GET" action="jump.jsp?id=2">
				<ol class="fs-fields">					
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q1" data-info="About future">你对未来有什么打算?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q1a" name="q1" type="radio" value="studyAbroad"/><label for="q1a" class="radio-conversion">留学国外</label></span>
							<span><input id="q1b" name="q1" type="radio" value="graudateStudy"/><label for="q1b" class="radio-conversion">读研</label></span>
							<span><input id="q1c" name="q1" type="radio" value="work"/><label for="q1c" class="radio-conversion">工作</label></span>
							<span><input id="q1d" name="q1" type="radio" value="notSure"/><label for="q1d" class="radio-mobile">还没有考虑</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q2" data-info="About mood">你是否容易焦躁?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q2a" name="q2" type="radio" value="yes"/><label for="q2a" class="radio-yes">是</label></span>
							<span><input id="q2b" name="q2" type="radio" value="no"/><label for="q2b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q3" data-info="About mood">你是否容忍他人焦躁?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q3a" name="q3" type="radio" value="yes"/><label for="q3a" class="radio-yes">是</label></span>
							<span><input id="q3b" name="q3" type="radio" value="no"/><label for="q3b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q4" data-info="About mood">你是否希望在人际关系交往中占据主导地位?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q4a" name="q4" type="radio" value="yes"/><label for="q4a" class="radio-yes">是</label></span>
							<span><input id="q4b" name="q4" type="radio" value="no"/><label for="q4b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q5" data-info="About mood">在帮助他人的问题上，你是否能在力所能及的时候给予援手?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q5a" name="q5" type="radio" value="yes"/><label for="q5a" class="radio-yes">是</label></span>
							<span><input id="q5b" name="q5" type="radio" value="no"/><label for="q5b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q6" data-info="About mood">你是否能按时按量的完成你的承诺?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q6a" name="q6" type="radio" value="yes"/><label for="q6a" class="radio-yes">是</label></span>
							<span><input id="q6b" name="q6" type="radio" value="no"/><label for="q6b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q7" data-info="About mood">你是否认为寝室规则有存在的必要性?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q7a" name="q7" type="radio" value="yes"/><label for="q7a" class="radio-yes">是</label></span>
							<span><input id="q7b" name="q7" type="radio" value="no"/><label for="q7b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q8" data-info="About life">你是否注意个人卫生?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q8a" name="q8" type="radio" value="yes"/><label for="q8a" class="radio-yes">是</label></span>
							<span><input id="q8b" name="q8" type="radio" value="no"/><label for="q8b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q9" data-info="About life">你是否容忍室友个人卫生?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q9a" name="q9" type="radio" value="yes"/><label for="q9a" class="radio-yes">是</label></span>
							<span><input id="q9b" name="q9" type="radio" value="no"/><label for="q9b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q10" data-info="About life">你是否熬夜?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q10a" name="q10" type="radio" value="yes"/><label for="q10a" class="radio-yes">是</label></span>
							<span><input id="q10b" name="q10" type="radio" value="no"/><label for="q10b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q11" data-info="About life">你是否容忍熬夜?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q11a" name="q11" type="radio" value="yes"/><label for="q11a" class="radio-yes">是</label></span>
							<span><input id="q11b" name="q11" type="radio" value="no"/><label for="q11b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q12" data-info="About life">你是否打呼噜、磨牙、梦话、梦游?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q12a" name="q12" type="radio" value="yes"/><label for="q12a" class="radio-yes">是</label></span>
							<span><input id="q12b" name="q12" type="radio" value="no"/><label for="q12b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q13" data-info="About life">你是否在寝室吸烟?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q13a" name="q13" type="radio" value="yes"/><label for="q13a" class="radio-yes">是</label></span>
							<span><input id="q13b" name="q13" type="radio" value="no"/><label for="q13b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q14" data-info="About life">你是否容忍室友喝醉酒后回寝室乱闹?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q14a" name="q14" type="radio" value="yes"/><label for="q14a" class="radio-yes">是</label></span>
							<span><input id="q14b" name="q14" type="radio" value="no"/><label for="q14b" class="radio-no">否</label></span>
						</div>
					</li>
					<li data-input-trigger>
						<label class="fs-field-label fs-anim-upper" for="q15" data-info="About life">你是否容忍室友带异性回寝室?</label>
						<div class="fs-radio-group fs-radio-custom clearfix fs-anim-lower">
							<span><input id="q15a" name="q15" type="radio" value="yes"/><label for="q15a" class="radio-yes">是</label></span>
							<span><input id="q15b" name="q15" type="radio" value="no"/><label for="q15b" class="radio-no">否</label></span>
						</div>
					</li>
					<li>
						<label class="fs-field-label fs-anim-upper" for="q16">你想要的室友的学号是多少?</label>
						<input class="fs-anim-lower" id="q16" name="q16" type="text" placeholder=" your favorite gay's id" required />
					</li>
					<li>
						<label class="fs-field-label fs-anim-upper" for="q17">你的绩点是多少?</label>
						<input class="fs-anim-lower" id="q17" name="q17" type="text" placeholder=" your GPA" required autofocus/>
					</li>
				</ol>
				<button class="fs-submit" type="submit">提交问卷</button>
			</form>
		</div>
	</div>
	<script src="js/classie.js"></script>
	<script src="js/selectFx.js"></script>
	<script src="js/fullscreenForm.js"></script>
	<script>
		(function() {
			var formWrap = document.getElementById( 'fs-form-wrap' );
			
			[].slice.call( document.querySelectorAll( 'select.cs-select' ) ).forEach( function(el) {	
				new SelectFx( el, {
					stickyPlaceholder: false,
					onChange: function(val){
						document.querySelector('span.cs-placeholder').style.backgroundColor = val;
					}
				});
			} );

			new FForm( formWrap, {
				onReview : function() {
					classie.add( document.body, 'overview' ); // for demo purposes only
				}
			} );
		})();
		</script>
</body>
</html>