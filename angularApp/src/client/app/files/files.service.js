(function() {
    'use strict';

    angular
        .module('app.files')
        .factory('FilesService', FilesService);

    FilesService.$inject = ['$http'];
    /* @ngInject */
    function FilesService($http) {

        var host = 'http://pakonatsrv.mooo.com:8080/';
        var endpoint = 'mediacenter/files';

        return {
            find: find
        };

        function find() {
            return $http.get(host + endpoint)
                .then(function(response) {
                    return response.data;
                });
        }
    }
})();
