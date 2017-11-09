/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {
    var mod = ng.module("restauranteModule", ['ui.router']);
    mod.constant("restaurantesContext", "api/sucursales");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/restaurantes/';
            $urlRouterProvider.otherwise("/restaurantesList");

            $stateProvider.state('restaurantes', {
                url: '/restaurantes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'restaurantes.html',
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('restaurantesList', {
                url: '/list',
                parent: 'restaurantes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'restaurantes.list.html'
                    }
                }
            }).state('restauranteDetail', {
                url: '/{restauranteId:int}/detail',
                parent: 'restaurantes',
                param: {
                    restauranteId: null
                },
                views: {
                    'listView': {
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'restaurantes.detail.html',
                        controller: 'restauranteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('restaurantesCreate', {
                url: '/create',
                parent: 'restaurantes',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/restaurantes.new.html',
                        controller: 'restauranteNewCtrl'
                    }
                }
            }).state('restauranteUpdate', {
                url: '/update/{restauranteId:int}',
                parent: 'restaurantes',
                param: {
                    authorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/restaurantes.new.html',
                        controller: 'restauranteUpdateCtrl'
                    }
                }
            }).state('restauranteDelete', {
                url: '/delete/{restauranteId:int}',
                parent: 'restaurantes',
                param: {
                    restauranteId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/restaurante.delete.html',
                        controller: 'restauranteDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);
