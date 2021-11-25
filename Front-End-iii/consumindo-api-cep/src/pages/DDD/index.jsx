import { useEffect, useState } from "react";
import { useParams } from "react-router"
import Swal from "sweetalert2";
import api from "../../service/api_brasilapi";


export default function Ddd(){

    const [info, setInfo] = useState({});
    const { ddd } = useParams();

    useEffect(() => {
        if(ddd){
            getData();
        }
    }, [ddd] )

    const getData = async () => {
        try{
            const response = await api.get(`https://brasilapi.com.br/api/ddd/v1/${ddd}`);
            console.log(response.data)
            console.log(response.ddd)
            setInfo(response.data);
        } catch (error) {
            Swal.fire({
                title: error.response.status,
                icon: 'error',
                text: error.response.statusText
              })
        }
    }

    return (
        <>
            {info && (
                <ol>
                <h1>Área de abrangência do DDD {ddd}</h1>
                <h3>Estado: {info.state}</h3>
                    {info.cities && info.cities.map((cite, i) => {
                        return <li key={i}>{cite}</li>
                    })}
                </ol>
            )}
        </>
    )
}