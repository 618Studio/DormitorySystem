<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>display</title>
	<style type="text/css" media="screen">
		@import url(http://fonts.googleapis.com/css?family=Ubuntu);
		
		* {margin: 0; padding: 0; }
		
		body {
			font-family: Ubuntu, arial, verdana;
			background: #0586AD;
		}
		
		/*----------
		Blocks
		----------*/
		/*Pricing table and price blocks*/
		.pricing_table {
			line-height: 150%; 
			font-size: 12px; 
			margin: 0 auto; 
			width: 75%; 
			max-width: 800px; 
			padding-top: 10px;
			margin-top: 100px;
		}
		
		.price_block {
			text-align: center; 
			width: 100%; 
			color: #fff; 
			float: left; 
			list-style-type: none; 
			transition: all 0.25s; 
			position: relative; 
			box-sizing: border-box;
			
			margin-bottom: 10px; 
			border-bottom: 1px solid transparent; 
		}
		
		/*Price heads*/
		.pricing_table h3 {
			text-transform: uppercase; 
			padding: 5px 0; 
			background: #333; 
			margin: -10px 0 1px 0;
		}
		
		/*Price tags*/
		.price {
			display: table; 
			background: #444; 
			width: 100%; 
			height: 70px; 
		}
		.price_figure {
			font-size: 24px; 
			text-transform: uppercase; 
			vertical-align: middle; 
			display: table-cell;
		}
		.price_number {
			font-weight: bold; 
			display: block;
		}
		.price_tenure {
			font-size: 11px; 
		}
		
		/*Features*/
		.features {
			background: #DEF0F4; 
			color: #000;
		}
		.features li {
			padding: 8px 15px;
			border-bottom: 1px solid #ccc; 
			font-size: 11px; 
			list-style-type: none;
		}
		
		.footer {
			padding: 15px; 
			background: #DEF0F4;
		}
		.action_button {
			text-decoration: none; 
			color: #fff; 
			font-weight: bold; 
			border-radius: 5px; 
			background: linear-gradient(#666, #333); 
			padding: 5px 20px; 
			font-size: 11px; 
			text-transform: uppercase;
		}
		
		.price_block:hover {
			box-shadow: 0 0 0px 5px rgba(0, 0, 0, 0.5); 
			transform: scale(1.04) translateY(-5px); 
			z-index: 1; 
			border-bottom: 0 none;
		}
		.price_block:hover .price {
			background:linear-gradient(#DB7224, #F9B84A); 
			box-shadow: inset 0 0 45px 1px #DB7224;
		}
		.price_block:hover h3 {
			background: #222;
		}
		.price_block:hover .action_button {
			background: linear-gradient(#F9B84A, #DB7224); 
		}
		
		
		@media only screen and (min-width : 480px) and (max-width : 768px) {
			.price_block {width: 50%;}
			.price_block:nth-child(odd) {border-right: 1px solid transparent;}
			.price_block:nth-child(3) {clear: both;}
			
			.price_block:nth-child(odd):hover {border: 0 none;}
		}
		@media only screen and (min-width : 768px){
			.price_block {width: 25%;}
			.price_block {border-right: 1px solid transparent; border-bottom: 0 none;}
			.price_block:last-child {border-right: 0 none;}
			
			.price_block:hover {border: 0 none;}
		}
		
		.skeleton, .skeleton ul, .skeleton li, .skeleton div, .skeleton h3, .skeleton span, .skeleton p {
			border: 5px solid rgba(255, 255, 255, 0.9);
			border-radius: 5px;
			margin: 7px !important;
			background: rgba(0, 0, 0, 0.05) !important;
			padding: 0 !important;
			text-align: left !important;
			display: block !important;
			
			width: auto !important;
			height: auto !important;
			
			font-size: 10px !important;
			font-style: italic !important;
			text-transform: none !important;
			font-weight: normal !important;
			color: black !important;
		}
		.skeleton .label {
			font-size: 11px !important;
			font-style: italic !important;
			text-transform: none !important;
			font-weight: normal !important;
			color: white !important;
			border: 0 none !important;
			padding: 5px !important; 
			margin: 0 !important;
			float: none !important;
			text-align: left !important;
			text-shadow: 0 0 1px white;
			background: none !important;
		}
		.skeleton {
			display: none !important;
			margin: 100px !important;
			clear: both;
		}
	</style>
</head>
<body>
	<ul class="pricing_table">
		<li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">姓名</span>
				</div>
			</div>
			<ul class="features">
				<li>是否注意个人卫生</li>
				<li>是否吸烟</li>
				<li>是否睡觉打呼噜，磨牙，梦游</li>
				<li>是否熬夜</li>
				<li>未来规划</li>
				<li>年级</li>
			</ul>
		</li>
		<li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">姓名</span>
				</div>
			</div>
			<ul class="features">
				<li>是否注意个人卫生</li>
				<li>是否吸烟</li>
				<li>是否睡觉打呼噜，磨牙，梦游</li>
				<li>是否熬夜</li>
				<li>未来规划</li>
				<li>年级</li>
			</ul>
		</li>
		<li class="price_block">
			<div class="price">
				<div class="price_figure">
					<span class="price_number">姓名</span>
				</div>
			</div>
			<ul class="features">
				<li>是否注意个人卫生</li>
				<li>是否吸烟</li>
				<li>是否睡觉打呼噜，磨牙，梦游</li>
				<li>是否熬夜</li>
				<li>未来规划</li>
				<li>年级</li>
			</ul>
		</li>
	</ul>
</body>
</html>