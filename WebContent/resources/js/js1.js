$(document).ready(function() {
	
	$('body').on('click', '.sliders', function() {
		var myDiv = this
		if ($(myDiv).next().css('display')=='none') {
			$(myDiv).next().slideDown(500)
		} else {
			$(myDiv).next().slideUp(500)
		}

	})
	
	//####################
	
	function ajax(element) {
		var method = element.dataset.method
		switch (method) {
		case "GET":
			var url = "http://localhost:8282/books/"+$(element).data('id')
			var url = "http://localhost:8282/books"
			console.log('GET')
			break;
		case "POST":
			var inputs = document.querySelectorAll('.book-post input')
			var url = "http://localhost:8282/books/add"
			var data = JSON.stringify({title:inputs[0].value,author:inputs[1].value,isbn:inputs[4].value, publisher:inputs[3].value,type:inputs[2].value})
			console.log('POST')
			break;
		case "DELETE":
			var toDel = element.parentElement
			var url = "http://localhost:8282/books/remove/"+$(toDel).data('id')
			console.log('DELETE')
			break;
		default: 
			console.log(`Błąd metody`);
			return;
		}
		
		$.ajax({
			headers:{
				'Accept':'application/json',
				'Content-Type':'application/json'
			},
			url: url,
			type: method,
			data: data,
		})
	
	}
	
//######### i jeszcze z gista od Anki - FAJNA METODA, która pozwala nie pisać kilka razy ajax(......) ####
/*	function ajaxCaller(url, callback, method){
	  $.ajax({
	    url: url,
	    type:method||'GET',
	    })
	  .done(function(result){
	    console.log(result);
	    callback(result);
	  });
	}
	
	var baseURL="http://localhost:8282/books";
	clickOnHeaders();
	ajaxCaller(baseURL, addBooks);*/
		

	$("#postBtn").on('click', function(event){
		event.preventDefault()
		var inputs = document.querySelectorAll('.book-post input')
		$.ajax({
			headers:{
				'Accept':'application/json',
				'Content-Type':'application/json'
			},
			url: "http://localhost:8282/books/add",
			type: "POST",
			data: JSON.stringify({title:inputs[0].value,author:inputs[1].value,isbn:inputs[4].value, publisher:inputs[3].value,type:inputs[2].value}),
			
		})
		.done(function(result,status,xhr){
			console.log(result,status,xhr);
			getBooks()
		})
		.fail(function(result,status,xhr){
			console.log(result,status,xhr);
		});
	});
	
	function getBooks(){
		$.ajax({url: "http://localhost:8282/books"})
		.done(function(result){
			$('#div1').html('')
			for (var i = 0; i <result.length; i++) {
				var titleDiv=$('<div>').text(result[i].title).addClass('titles');
				titleDiv[0].dataset.id=result[i].id;
				var newDiv = $('<div>').text('szczegóły').addClass('details').css('display','none')
				$('#div1').append(titleDiv).append(newDiv).append('</br>')
			}
		});
	}

	$("#bt1").on('click', function() {
		getBooks()
	});
	
	$('body').on('click', '.dels', function() {
		var myDel = this.parentElement
		console.log(myDel)
		$.ajax({
			headers:{
				'Accept':'application/json',
				'Content-Type':'application/json'
			},
			url: "http://localhost:8282/books/remove/"+$(myDel).data('id'),
			type: "DELETE",
			
		})
		.done(function(result,status,xhr){
			console.log(result,status,xhr);
			getBooks()
		})
		.fail(function(result,status,xhr){
			console.log(result,status,xhr);
		})
		
	})
	
	$('body').on('click', '.titles', function() {
		var myDiv = this
		if ($(myDiv).next().css('display')=='none') {
			$.ajax({url: "http://localhost:8282/books/"+$(myDiv).data('id')})
			.done(function(result){
				$(myDiv).next().html("Title: "+result.title+"</br>"+" Author: "+result.author+"</br>"
						+" Publisher: "+result.publisher+"</br>"+" ISBN: "+result.isbn+"</br>"
						+" Type: "+result.type+"</br>"
						+"<a class='dels' href=# >Usuń</a>")
				.slideDown(500)
				myDiv.nextElementSibling.dataset.id=$(myDiv).data('id')
			})
		} else {
			$(myDiv).next().slideUp(500)
		}

	})

})
