var appDesafio = angular.module("appDesafio",['ngRoute'])


appDesafio.config(function($routeProvider){
	$routeProvider
	.when("/operadores",{templateUrl:'view/crud-operador.html', controller: 'cadastroOperador'})
	.when("/login",{templateUrl:'view/login.html'})
	.otherwise({rediretTo:'/'});
});
