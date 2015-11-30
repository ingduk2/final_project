<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TeamD</title>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style type="text/css">
	#allbg{
		background-image: url('http://cfile25.uf.tistory.com/image/203F8F335021021C1996EB');
		background-repeat: no-repeat;
		width: 100%;
		height: 100%;
		background-size:100% 100%;
	}
	.jumbotron{
		margin: 10px;
		border-radius: 5px;
		background-color: rgba( 208, 210, 208, 0.9 );
		padding: 30px;
		font-size:12px;
	}
	.h1, .h2, .h3, h1, h2, h3{
		margin-top: 3px;
		margin-bottom: 3px;
	}
	hr{
		margin-top: 0px;
		margin-bottom: 3px;
		border: 0;
		border-top: 1px solid #eee;
	}
	.table {
		width: 80%;
		max-width: 100%;
		margin-bottom: 5px;
	}
	.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th{
		padding: 3px;
	}
	ol, ul{
		margin-bottom: 1px
	}
</style>
<script>
	function fin() {
		window.close();
	}
</script>
</head>
<body>
<div id="allbg">
	<div class="jumbotron">
	   <h3>TNR<small>�������� ������ �ǰ��� ��ٸ��ϴ�.</small></h3>
	   <hr>
	   <font size="3px">&nbsp;
	  TNR(Trap-Neuter-Release) �̶� ������̸� ��ȹ�� �� �߼�ȭ ������ ���� ��ȹ�� ��ҿ� �ٽ� ����ϴ� ������, �ε����� �������� ��������� ��ü ���� ������ �� �ִ� ����̴�</font>
	   <table class="table">
	   	<tr>
	   		<td>����</td>
	   		<td>
	   			<ul>
	   				<li>�߼�ȭ�� �� ������̴� ������ �Ҹ��� ���� �ʾ� ������ �پ���</li>
	   				<li>Ÿ���� �������� ������ �����ش�</li>
	   				<li>������ ��������� ��ü�� ������ ���� ������ ���ĵ� �����Ѵ�</li>
	   			</ul>
	   		</td>
	   	</tr>
	   	<tr>
	   		<td>����</td>
	   		<td>
	   			<ul>
	   				<li>�߼�ȭ ���� ����� ������ 14������ �߻��Ѵ�</li>
	   				<li>�������� ��ü�� ������ ���°� ������ �߱��Ѵ�</li>
	   			</ul>
	   		</td>
	   	</tr>
	   </table>
	   
	   <p>
	   <font size="3px">&nbsp;. ���� ���￡�� 20�� ������ ������̰� �ִ� ������ �����˴ϴ�. �߼�ȭ ���� ��뵵 ������ 14�� �� ������ ���� ��������. �þ�� �������, ��� �ذ��ؾ� �ұ��?</font>
	   <p><p><p>
	   
	    <div class="radio">
	      <label><input type="radio" name="optradio">���� ��ü���� �Ѿ ��� ��ȹ�ؼ� �ȶ����Ų��</label>
	    </div>
	    <div class="radio">
	      <label><input type="radio" name="optradio">�߼�ȭ ������ ���� ��������� ��ü���� �����Ѵ�</label>
	    </div>
	    <div class="radio">
	      <label><input type="radio" name="optradio">��Ÿ</label>
	    </div>
	    
	    <span style="color: red">
	    	<strong>�� �� ��������� �α����� �ʿ���� ����������� �����ϰ�,<br>
	    	����IP���� �ߺ���ǥ�� �����Ͽ� ���Ǽ��� �����մϴ�.</strong> 
	    </span>
	    <button type="button" onclick="fin()" class="btn btn-default btn-sm" style="margin-bottom: -15px; margin-left: 90%">��ǥ�ϱ�</button>
	    
	 </div>
</div>
</body>
</html>