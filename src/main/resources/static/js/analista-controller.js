/*
 * Programadora: Rebeca Divina Paula
 */

appDesafio.controller("analistaController",  function($scope, $http){

	$scope.listapessoas      = listapessoas;
	$scope.geraData          = geraData;
	$scope.formataCPF        = formataCPF;
	$scope.formataCNPJ       = formataCNPJ;
	
	
	$scope.pessoas = [];
	$scope.pessoa = {};
	$scope.mensagem = '';
	
	function init(){
		$scope.listapessoas();
	}
	
	init();
	

	function listapessoas(){
		 $http.get('http://localhost:8080/listaPessoas/')
         .then(function (response) {
 			$scope.pessoas = response.data;
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });

	}

	 function formataCPF(cpf){
		return cpf.substr(0,3)+"."+cpf.substr(3,3) + '.' + cpf.substr(6,3) + '-' + cpf.substr(9,2);
	 }
	 
	 function formataCNPJ(cnpj){
		 return cnpj.substr(0,3)+"."+cnpj.substr(3,3) + '.' + cnpj.substr(6,3) + '/' + cnpj.substr(9,4) + '-' + cnpj.substr(13,2);
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
