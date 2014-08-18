<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<body>
		<script type="text/javascript">
function update(aa,bb,cc){
document.f2.id.value=aa;
document.f2.userName.value=bb;
document.f2.password.value=cc;}
function query(){
var id=document.f4.id.value;
var id2=document.f4.id2.value;
var userName=document.f4.userName.value;
var password=document.f4.password.value;
if(id!=""&&id2==""){
alert("请将id号段填写完整");
return;
}
if(id==""&&userName==""&&password==""){
alert("请至少填写一项查询条件");
return;
}
window.location.href="querybymore?id="+id+"&userName="+userName+"&password="+password+"&id2="+id2;
}
function dels(){
var str=document.getElementsByName("ck");
var ids="";
for (i=0;i<str.length;i++)
{
  if(str[i].checked==true)
  {
   ids+=str[i].value+",";
  }
}
if(ids=="")
{
alert("请至少选择一行");
}
else
{
alert("你选择的是："+ids.substr(0,ids.length-1));
window.location.href="bathdeluser?ids="+ids.substr(0,ids.length-1);
}
}
function selectAll(){//全选
var str=document.getElementsByName("ck");
for(i=0;i<str.length;i++)
{document.getElementById(str[i].value).checked="checked";}
}
function unselectAll(){//全不选
var str=document.getElementsByName("ck");
for(i=0;i<str.length;i++)
{document.getElementById(str[i].value).checked="";}
}
</script>
		<table align="center">
			<h2 align="center">
				欢迎${userName}登入
				<br />
			</h2>
			<hr>
			<hr>
			<hr>
			<hr>

			<form id="f4" name="f4" method="post">
				依据id号段查询:
				<input type="text" name="id">
				-
				<input type="text" name="id2">
				<br />
				依据账号来查询:
				<input type="text" name="userName">
				(支持模糊账号)
				<br />
				依据密码来查询:
				<input type="text" name="password">
				
				<br/><br/><br/>
				<input type="button" value="查询" onclick="query();">
				
				
				查询结果是:
				<hr>

				<s:iterator value="usersquery">
                  密码: <s:property value="password" />
                  账号: <s:property value="userName" />
                id: <s:property value="id" />
					<br />
					<hr>
					<br />
				</s:iterator>
				<hr>
			</form>
			<form action="adduser" method="post">
				新增一个用户:
				<br />
				账号:
				<input type="text" name="userName">
				<br />
				密码:
				<input type="password" name="password">
				<input type="submit" value="提交">
			</form>
			<hr>
			//用户列表
			<br />

			<s:iterator value="users">
		 序号<s:property value="id" />
				<input type="checkbox" name="ck" id="${id}" value="${id}" /> 账号:<s:property
					value="userName" />  密码: <s:property value="password" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="deluser?id=${id}" style="text-decoration: none">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
					href="javascript:update('${id}','${userName}','${password}')"
					style="text-decoration: none">修改</a>
				<br />
				<hr>
			</s:iterator>
			<table align="center">
				总共${CountRecords}条记录,共${pages}页 当前位于第${pageNo}页
				<br />
				<br />
				<br />


				<s:if test="%{pageNo==1}">

					<a href="javascript:void(0)"
						style="cursor: default; text-decoration: none"><font
						color="Silver" size="2">&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;</font>
					</a>

				</s:if>

				<s:else>

					<a href="getAlluser?pageNo=${pageNo-1}"
						style="text-decoration: none">&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;</a>
				</s:else>

				<s:if test="%{pageNo==#session.pages}">
					<a href="javascript:void(0)"
						style="cursor: default; text-decoration: none"><font
						color="Silver" size="2">&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;</font>
					</a>

				</s:if>

				<s:else>
					<a href="getAlluser?pageNo=${pageNo+1}"
						style="text-decoration: none">&nbsp;&nbsp;&nbsp;下一页&nbsp;&nbsp;&nbsp;</a>
				</s:else>


				<s:if test="%{pageNo==1}">
					<a href="javascript:void(0)"
						style="cursor: default; text-decoration: none"><font
						color="Silver" size="2">&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;</font>
					</a>
				</s:if>
				<s:else>
					<a href="getAlluser?pageNo=1" style="text-decoration: none">&nbsp;&nbsp;&nbsp;首页&nbsp;&nbsp;&nbsp;</a>
				</s:else>

				<s:if test="%{pageNo==#session.pages}">
					<a href="javascript:void(0)"
						style="cursor: default; text-decoration: none"><font
						color="Silver" size="2">&nbsp;&nbsp;&nbsp;最后一页&nbsp;&nbsp;&nbsp;</font>
					</a>
				</s:if>
				<s:else>
					<a href="getAlluser?pageNo=${pages}" style="text-decoration: none">&nbsp;&nbsp;&nbsp;最后一页</a>
				</s:else>

			</table>
			<form action="updateuser" method="post" id="f2" name="f2">
			<table align="center">
				修改一个用户:
				<br />
				<input type="hidden" name="id">
				<br />
				账号:
				<input type="text" name="userName">
				<br />
				密码:
				<input type="text" name="password">
				<input type="submit" value="确认修改">
				<input type="button" value="批量删除" onclick="dels()">
				<input type="button" value="全选" onclick="selectAll()">
				<input type="button" value="全不选" onclick="unselectAll()">
				</table>
			</form>
		</table>
	</body>
</html>