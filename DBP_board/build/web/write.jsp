<%@ page language="java" contentType="text/html; charset=euc-kr" %>
<!DOCTYPE html>
<html>
<head>
  <title> TeamName | QnA </title>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
  <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
  <script src="semantic/semantic.js"></script>
  <link rel="stylesheet" type="text/css" href="semantic/semantic.css" />

  <script>
    function Check() {
      if (Write.name.value.length < 1) {
        alert("�ۼ��ڸ� �Է��ϼ���.");
        Write.name.focus();
        return false;
      }

      if (Write.pass.value.length < 1) {
        alert("��й�ȣ�� �Է��ϼ���.");
        Write.pass.focus();
        return false;
      }

      if (Write.email.value.indexOf("@") + "" == "-1" ||
        Write.email.value.indexOf(".") + "" == "-1" ||
        Write.email.value == "") {
        alert("E-mail�� �Է��ϼ���.");
        Write.email.focus();
        return false;
      }

      if (Write.title.value.length < 1) {
        alert("�������� �Է��ϼ���.");
        Write.write_title.focus();
        return false;
      }

      if (Write.contents.value.length < 1) {
        alert("�۳����� �Է��ϼ���.");
        Write.content.focus();
        return false;
      }
    }
  </script>
  <style>
    div.field {
      padding-left: 10px;
      padding-right: 10px;
    }
    form {
      margin-top: 30px;
    }
    @media(min-width: 720px){
      #writer, #password, #email{
        width: 50%;
      }
    }
  </style>
</head>

<body>

  <form class="ui form" name="Write" action="write_input.jsp" method="post" enctype="multipart/form-data" onsubmit="return Check()">
    <h1 class="ui dividing header"><center>Q & A</center></h1>
    <div class="field">
      <label>* �ۼ���</label>
      <input id="writer" type="text" name="name" placeholder="writer" />
    </div>
    <div class="field">
      <label>* ��й�ȣ(�Խù� ���� ������ �ʿ��մϴ�.)</label>
      <input id="password" type="password" name="pass" placeholder="password" />
    </div>
    <div class="field">
      <label>�̸���</label>
      <input id="email" type="email" name="email" placeholder="e-mail" />
    </div>
    <div class="field">
      <label>���� ÷��(����, ���� ���ϸ� ���ε� �����մϴ�.)</label>
      <div class="ui action input">
        <input type="text" id="_attachmentName" placeholder="filename" readonly>
        <label for="attachmentName" class="ui icon button btn-file">
             <i class="attach icon"></i>
             <input type="file" id="attachmentName" name="filename" style="display: none">
        </label>
      </div>
    </div>
    <div class="field">
      <label>�� ����</label>
      <input type="text" name="title" placeholder="write title" />
    </div>
    <div class="field">
      <label>�� ����</label>
      <textarea name="contents" placeholder="write contents"></textarea>
    </div>
    <div class="field">
      <input class="ui button" type="reset" value="�ٽ� �ۼ�"/>
      <input class="ui button" type="submit" value="���">
      <input type="button" class="ui button" value="�������" onclick="location.href='./listboard.jsp'">
    </div>
  </form>
    
  <script>
    var fileExtentionRange = '.zip .rar .tar .pdf .doc .docx .xls .xlsx .ppt .pptx .hwp .jpg .jpeg .png';
    var MAX_SIZE = 30; // MB

    $(document).on('change', '.btn-file :file', function() {
      var input = $(this);

      if (navigator.appVersion.indexOf("MSIE") != -1) { // IE
        var label = input.val();

        input.trigger('fileselect', [1, label, 0]);
      } else {
        var label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
        var numFiles = input.get(0).files ? input.get(0).files.length : 1;
        var size = input.get(0).files[0].size;

        input.trigger('fileselect', [numFiles, label, size]);
      }
    });

    $('.btn-file :file').on('fileselect', function(event, numFiles, label, size) {
      $('#attachmentName').attr('name', 'attachmentName'); // allow upload.

      var postfix = label.substr(label.lastIndexOf('.'));
      if (fileExtentionRange.indexOf(postfix.toLowerCase()) > -1) {
        if (size > 1024 * 1024 * MAX_SIZE) {
          alert('max size��<strong>' + MAX_SIZE + '</strong> MB.');

          $('#attachmentName').removeAttr('name'); // cancel upload file.
        } else {
          $('#_attachmentName').val(label);
        }
      } else {
        alert('���� Ȯ���ڴ£�' + fileExtentionRange + '�� �Է� �����մϴ�.');

        $('#attachmentName').removeAttr('name'); // cancel upload file.
      }
    });
  </script>
</body>

</html>
