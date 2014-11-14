
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:wrapper>

	<link href='../../css/main.css' rel='stylesheet' />
	<link href='../../css/fullcalendar.css' rel='stylesheet' />
	<link href='../../css/fullcalendar.print.css' rel='stylesheet'
		media='print' />
	<script src='../../js/moment.min.js'></script>
	<script src='../../js/jquery-1.11.1.min.js'></script>
	<script src='../../js/fullcalendar.min.js'></script>
	<script>
		$('document').ready(function() {
			loadTabs();
		});

		function loadTabs() {
			$('#tabs li a').each(function() {
				$(this).click(function() {
					$('#tabs li').each(function() {
						$(this).removeClass('tab-selected');
					});
					$(this).parent().addClass('tab-selected');
					//show new tab and hide others
					var index = $(this).parent().index();
					$("#tab-" + index).show().siblings().hide();
					return false;
				});
			});
		}

		$(document).ready(function() {

			$('#fullCalendar').fullCalendar({
				header : {
					left : 'prev,next today',
					center : 'title',
					right : 'month,agendaWeek,agendaDay'
				},
				defaultDate : '2014-09-12',
				editable : true,
				eventLimit : true, // allow "more" link when too many events
				events : [ {
					title : 'All Day Event',
					start : '2014-09-01'
				}, {
					title : 'Long Event',
					start : '2014-09-07',
					end : '2014-09-10'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-09T16:00:00'
				}, {
					id : 999,
					title : 'Repeating Event',
					start : '2014-09-16T16:00:00'
				}, {
					title : 'Conference',
					start : '2014-09-11',
					end : '2014-09-13'
				}, {
					title : 'Meeting',
					start : '2014-09-12T10:30:00',
					end : '2014-09-12T12:30:00'
				}, {
					title : 'Lunch',
					start : '2014-09-12T12:00:00'
				}, {
					title : 'Meeting',
					start : '2014-09-12T14:30:00'
				}, {
					title : 'Happy Hour',
					start : '2014-09-12T17:30:00'
				}, {
					title : 'Dinner',
					start : '2014-09-12T20:00:00'
				}, {
					title : 'Birthday Party',
					start : '2014-09-13T07:00:00'
				}, {
					title : 'Click for Google',
					url : 'http://google.com/',
					start : '2014-09-28'
				} ]
			});

		});
	</script>
	
	<style>.hidden{display: none}</style>
	<div class="grc-tab-div" style="margin: 0 auto;">
		<ul id="tabs">
			<li class="tab-selected"><a href="#"> <span>General
						Information</span>
			</a></li>
			<li><a href="#"><span>Opening Hours</span></a>
			<li><a href="#"><span>Holidays</span></a>
			<li><a href="#"><span>Exceptional Days</span></a>
		</ul>
	</div>


	<div class="grc-form block">
		<div id="tab-0" class="">
			test0
			<div id='fullCalendar'>here</div>
		</div>

		<div id="tab-1" class="hidden">test1</div>
		<div id="tab-2" class="hidden">test2</div>
		<div id="tab-3" class="hidden">test3</div>
	</div>
</t:wrapper>