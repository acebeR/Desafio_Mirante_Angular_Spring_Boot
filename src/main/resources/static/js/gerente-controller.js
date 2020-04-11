/*
 * Programadora: Rebeca Divina Paula
 */

appDesafio.controller("cadastropessoa",  function($scope, $http){

	$scope.listapessoas      = listapessoas;
	$scope.excluirpessoa     = excluirpessoa;
	$scope.alterarpessoa     = alterarpessoa;
	$scope.adicionarOp       = adicionarOp;
	$scope.init              = init;
	$scope.geraData          = geraData;
	$scope.formataCPF        = formataCPF;
	$scope.formataCNPJ       = formataCNPJ;
	$scope.controleAlterar   = controleAlterar;
	$scope.voltaData		 = voltaData;
	$scope.hoje = new Date();
	
	
	$scope.pessoas = [];
	$scope.nomeEdit = ""; 
	$scope.pessoa = {};
	$scope.alterar = false;
	$scope.validaLetraLogin = true;
	$scope.confSenha = "";
	$scope.mensagem = '';
	
	function init(){
		$scope.listapessoas();
	}
	
	init();
	

	function controleAlterar(p){
		
		var temp = new Date(p.data_nascimento);
		p.data_nascimento = temp;
		console.log(p.data_nascimento)
		if(p.tipoPessoa === 'FISICA'){
			p.documento = formataCPF(p.documento);
		}else{
			formataCNPJ(p.documento);
		}
		
		 
	}
	
	
	function listapessoas(){
		 $http.get('http://localhost:8080/listaPessoas/')
         .then(function (response) {
 			$scope.pessoas = response.data;
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });

	}
	
	 function excluirpessoa(pessoa){
		 $http.delete('http://localhost:8080/excluiPessoa/'+pessoa.id_pessoa)
         .then(function (response) {
        	 $scope.listapessoas();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function alterarpessoa(op){
		 var p = op;

		 $http.put('http://localhost:8080/alteraPessoa/', op)
         .then(function (response) {
        	 $scope.listapessoas();
         })
         .catch(function (response) {
        	 $scope.mensagem = response.data.message;
         });
	 }
	 
	 function adicionarOp(){
		 $http.post('http://localhost:8080/pessoas/', $scope.pessoa)
         .then(function (response) {
        	 $scope.listapessoas();
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
	 
	 function voltaData(data){
		var aux = data.split('-');
		var dia = aux[2];
		var mes = aux[1];
		var ano = aux[0];
		console.log(aux);
		return ano + '-' + mes + "-" + dia;
	 }
	 
	 function formataCPF(cpf){
		return cpf.substr(0,3)+"."+cpf.substr(3,3) + '.' + cpf.substr(6,3) + '-' + cpf.substr(9,2);
	 }
	 
	 function formataCNPJ(cnpj){
		 return cnpj.substr(0,3)+"."+cnpj.substr(3,3) + '.' + cnpj.substr(6,3) + '/' + cnpj.substr(9,4) + '-' + cnpj.substr(13,2);
	 }
	
});
