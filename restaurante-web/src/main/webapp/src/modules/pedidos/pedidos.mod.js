/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
var mod = ng.module("pedidoModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("pedidosContext", "api/pedidos");
    mod.config(['$stateProvider', '$urlRouterProvider', 
        function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/pedido/';
            $urlRouterProvider.otherwise("/pedidosList");

            $stateProvider.state('pedidosList', 
            {
                url: '/pedidos/list',
                views: {
                    'mainView': {
                        controller: 'pedidosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pedidos.list.html'
                    }
                }
            }
                    ).state('pedidosCreate', 
            {
                url: '/pedidos/create',
                views: {
                    'mainView': {
                        controller: 'pedidosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pedidos.create.html'
                    }
                }

            }
                    ).state('pedidosEdit', 
            {
                url: '/pedidos/:pedidosId',
                param: 
                        {
                    pedidosId: null
                },
                views: {
                    'mainView': {
                        controller: 'pedidosCtrl',
                        controllerAs: 'ctrl',
                        templateUrl: basePath + 'pedidos.create.html'
                    }
                }
            });
        }]);

})(window.angular);



