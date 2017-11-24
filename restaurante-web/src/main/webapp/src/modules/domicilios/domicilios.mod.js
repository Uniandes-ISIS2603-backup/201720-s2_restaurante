(function (ng) {
var mod = ng.module("domicilioModule", ['ui.router']); //declaracion del modulo, llamo la funcion de angular ng, el nombre del modulo y las dependencias
    mod.constant("domiciliosContext", "http://localhost:8080/restaurante-web/api/domicilios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) 
        {
            var basePath = 'src/modules/domicilios/';
            $urlRouterProvider.otherwise("/domiciliosList");
        $stateProvider.state('domicilios', {
                url: '/domicilios',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'domicilios.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('domiciliosList', {
                url: '/list',
                parent: 'domicilios',
                views: {
                    'listView': {
                        templateUrl: basePath + 'domicilios.list.html'
                    }
                }
            }).state('domicilioDetail', {
                url: '/{domicilioId:int}/detail',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'domicilios.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'domicilios.detail.html',
                        controller: 'domicilioCtrl',
                        controllerAs: 'ctrl'
                    }

                }
            
            }).state('domiciliosCreate', {
                url: '/create',
                parent: 'domicilios',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/domicilios.new.html',
                        controller: 'domicilioNewCtrl'
                    }
                }
            }).state('domicilioUpdate', {
                url: '/update/{domicilioId:int}',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/domicilios.new.html',
                        controller: 'domicilioUpdateCtrl'
                    }
                }
            }).state('domicilioDelete', {
                url: '/delete/{domicilioId:int}',
                parent: 'domicilios',
                param: {
                    domicilioId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/domicilios.delete.html',
                        controller: 'domicilioDeleteCtrl'
                    }
                }
            });
        }]);

})(window.angular);