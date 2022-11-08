import { useLocation } from "react-router-dom";

const Results = (props) =>{

    const location = useLocation();
    console.log(location.state)

    return(
        <div>
            <h1>Your Result is: {location.state}</h1>
        </div>
    );
}
export default Results;