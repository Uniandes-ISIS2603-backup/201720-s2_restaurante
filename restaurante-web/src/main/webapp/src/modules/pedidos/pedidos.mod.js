/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
var mod = ng.module("pedidoModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("pedidosContext", "api/pedidos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/pedidos/';
            $urlRouterProvider.otherwise("/pedidosList");

        $stateProvider.state('pedidos', {
                url: '/pedidos',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'pedidos.html',
                        controller: 'pedidosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pedidosList', {
                url: '/list',
                parent: 'pedidos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'pedidos.list.html'
                    }
                }
            }).state('pedidosDetail', {
                url: '/{pedidoId:int}/detail',
                parent: 'pedidos',
                param: {
                    pedidoId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'pedidos.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'pedidos.detail.html',
                        controller: 'pedidosCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            
            }).state('pedidoCreate', {
                url: '/create',
                parent: 'pedidos',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/pedidos.new.html',
                        controller: 'pedidoNewCtrl'
                    }
                }
            }).state('pedidoUpdate', {
                url: '/update/{pedidoId:int}',
                parent: 'pedidos',
                param: {
                    pedidoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/pedidos.new.html',
                        controller: 'pedidoUpdateCtrl'
                    }
                }
            }).state('pedidoDelete', {
                url: '/delete/{pedidoId:int}',
                parent: 'pedidos',
                param: {
                    pedidoId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/pedidos.delete.html',
                        controller: 'pedidoDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);



