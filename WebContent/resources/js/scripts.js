
//$botaoDeletar.addeventlistener('click', function(){
//	console.log('CLICOU');
//}, false)

$('.btn-danger').click(function(){
	
	const url = $(this).attr('data-url');
	
	$('.confirmarExclusao').click(function(){
		location.href = url;
	})
	
});

setTimeout(function(){
	$(".alert").alert('close')
}, 5000);


$('.botaoDetalhe').click(function(){
	
	const nomeAnime = $(this).attr('data-nomeAnime');
	const sinopse = $(this).attr('data-sinopse');
	
	document.querySelector('.card-title').innerText = nomeAnime;
	document.querySelector('.card-text').innerText = sinopse;
	
	
	$('#modalDetalhe').modal('show');
	
});
