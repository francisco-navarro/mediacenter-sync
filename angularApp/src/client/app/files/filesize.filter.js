(function() {
    'use strict';

    angular
        .module('app.files')
        .filter('fileSizeFilter', fileSizeFilter);

    fileSizeFilter.$inject = ['numberFilter'];
    /* @ngInject */
    function fileSizeFilter(numberFilter) {

        var units = ['B', 'KB', 'MB', 'GB'];
        return function(input) {

            if (input) {
                return divide(input, 0);
            }

        };

        function divide(number, base) {
            if (number < 1024) {
                return parseInt(number) + ' ' + units[base];
            }
            return divide(parseInt(number) / 1024, base + 1);
        }
    }

}());
