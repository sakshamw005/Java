/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let p = init ;
    function increment(){
        return ++p ;
    }
    function decrement(){
        return --p ;
    }
    function reset(){
        return (p=init) ;
    }
    return { increment, decrement, reset };
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */