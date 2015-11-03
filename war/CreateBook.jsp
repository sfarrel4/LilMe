<html>
<head>
<title></title>
</head>


<body>

<form action="/add-book" method="post" id="bookForm">


Book Title: <input type="text" name="bookTitle" />
</br>
Book Author: <input type="text" name="bookAuthor" />
</br>
<textarea rows="4" cols="50" name="bookSynop" form="bookForm">
Enter the Book Synopsis...</textarea>
</br>
<textarea rows="4" cols="50" name="bookLessons" form="bookForm">
Enter the Book Lessons...</textarea>
</br>
<textarea rows="4" cols="50" name="bookQuestions" form="bookForm">
Enter the Book Questions...</textarea>
</br>
Book URL: <input type="text" name="bookImageURL" />
</br>
<input type="submit" value="Submit" />
</form>




</body>

</html>