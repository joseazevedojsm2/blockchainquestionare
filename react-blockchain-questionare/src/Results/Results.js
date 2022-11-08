import { useLocation } from "react-router-dom";

const Results = (props) =>{

    const location = useLocation();
    console.log(location.state)

    function getResult(){
        var points = location.state.result;
        var quest = location.state.nmb;
        var result = points.total /quest.number;
        console.log(result)
        if (result === 5)
            return 'Your afinity is MAX';
        if (result === 4)
            return 'Your afinity is NEEDED';
        if (result === 3)
            return 'Your afinity is IMPORTANT';
        if (result === 2)
            return 'Your afinity is ML';
        if (result === 1)
            return 'Your afinity is None';
    }

    return(
        <div>
            <h1>Result is:<p>{getResult()}</p> </h1>
        </div>
    );
}
export default Results;