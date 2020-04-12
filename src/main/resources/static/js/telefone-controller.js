/*
 * Programadora: Rebeca Divina Paula
 */

appDesafio.controller("telefoneController",  function($scope, $http, $route){

	
	$scope.adicionarTelefone = adicionarTelefone;
	$scope.listaTelefone     = listaTelefone;
	$scope.excluirTelefone   = excluirTelefone;
	$scope.alterarTelefone   = alterarTelefone;
	$scope.geraData			 = geraData;
	
	$scope.telefones = [];
	$scope.telefone = {};
	$scope.mensagem = '';
	$scope.idPessoa = '';
	$scope.pessoa = {};
	
	function init(){
		$scope.idPessoa = $route.current.params.id_pessoa;
		console.log($scope.idPessoa)
		$scope.listaTelefone();
	}
	
	init();
	
	
	
	
	function listaTelefone(){
		 $http.get('http://localhost:8080/listaTelefonespessoa/' + $scope.idPessoa)
         .then(function (response) {
 			$scope.telefones = response.data;
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });

	}
	
	 function excluirTelefone(telefone){
		 $http.delete('http://localhost:8080/excluiTelefones/'+ telefone.id_telefone)
         .then(function (response) {
        	 $scope.listaTelefone();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function alterarTelefone(telefone){

		 $http.put('http://localhost:8080/alteraTelefones/', telefone)
         .then(function (response) {
        	 $scope.listaTelefone();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function adicionarTelefone(){
		 $http.get('http://localhost:8080/listaPessoasPorId/' + $scope.idPessoa)
         .then(function (response) {
        	 $scope.pessoa = response.data;
        	 $scope.telefone.pessoa = $scope.pessoa;
        	 
    		 $http.post('http://localhost:8080/telefones/', $scope.telefone)
             .then(function (response) {
            	 $scope.listaTelefone();
             })
             .catch(function (response) {
            	 $scope.mensagem = response.data.message;
             });
        	 
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
		 

	 }
	 
	 function geraData(data){
		 console.log(data);
		var aux = data.split('-');
		var dia = aux[2];
		var mes = aux[1];
		var ano = aux[0];
		console.log(aux);
		return dia + '/' + mes + "/" + ano;
	 }

});
