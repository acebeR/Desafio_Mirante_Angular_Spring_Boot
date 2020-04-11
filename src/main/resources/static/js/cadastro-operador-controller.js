/*
 * Programadora: Rebeca Divina Paula
 */
appDesafio.controller("cadastroOperador",  function($scope, $http){
		
	$scope.listaOperadores = listaOperadores;
	$scope.excluirOperador = excluirOperador;
	$scope.alterarOperador = alterarOperador;
	$scope.adicionarOp     = adicionarOp;
	$scope.init            = init;
	$scope.geraData        = geraData;
	
	
	$scope.operadores = [];
	$scope.nomeEdit = ""; 
	$scope.operador = {};
	$scope.alterar = false;
	$scope.validaLetraLogin = true;
	$scope.confSenha = "";
	$scope.mensagem = "";
	
	token = localStorage.getItem("userToken");
	$http.defaults.headers.common.Authorization = 'Bearer ' + token;
	
	function init(){
		$scope.listaOperadores();
	}
	
	init();
	
	function listaOperadores(){
		 $http.get('http://localhost:8080/admin/listaoperadores/')
         .then(function (response) {
 			$scope.operadores = response.data;
 			console.log($scope.operadores);
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });

	}
	
	 function excluirOperador(operador){
		 $http.delete('http://localhost:8080/admin/excluioperadores/'+operador.id)
         .then(function (response) {
        	 $scope.listaOperadores();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function alterarOperador(op){
		 $http.put('http://localhost:8080/admin/alteraoperadores/', op)
         .then(function (response) {
        	 $scope.listaOperadores();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function adicionarOp(){
		 if($scope.operador.login != 'admin'){
			 $http.post('http://localhost:8080/admin/operadores/', $scope.operador)
	         .then(function (response) {
	        	 $scope.listaOperadores();
	         })
	         .catch(function (response) {
	        	 $scope.mensagem = response.data.message;
	         });
		 }else{
			 $scope.mensagem = "Voce nao pode cadastrar como admin";
		 }	 
		 
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
