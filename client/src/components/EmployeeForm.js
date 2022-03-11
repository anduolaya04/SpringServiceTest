import React, {useState} from 'react';

const API_HOST = "http://localhost:8001";
const INVENTORY_API_URL = `${API_HOST}/api`;

function EmployeeForm() {

    const [data, setData] = useState([]);

    return (
        <div className="EmployeeForm">
          <header className="EmployeeForm-Header">
            <input type="number" id='inquiry'/>
            <p></p>
            <button onClick={callApi}>Consultar</button>
            <p></p>
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Employee name</th>
                        <th>Employee Salary</th>
                        <th>Anual Salary</th>
                        <th>Employee age</th>
                        <th>Profile image</th>
                    </tr>
                </thead>
                <tbody>
                     {
                        data.map((item) => (
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.employee_name}</td>
                                <td>{item.employee_salary}</td>
                                <td>{item.anualSalary}</td>
                                <td>{item.employee_age}</td>
                                <td>{item.profile_image}</td>
                                <td/>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
          </header>
        </div>
    );

    function callApi() {

        var bruh = document.getElementById("inquiry").value;

        fetch(`${INVENTORY_API_URL}/${bruh}`, {method:'GET'})
            .then( res =>{
                if(res.ok){
                    return res.json();
                } 
            })
            .then( json =>{
                    if(Object.entries(json).length !== 0){
                        setData(json);
                    }  
                }
            )
            .catch(error =>{   
                alert("NOT FOUND");                  
                console.log('Request failed', error); 
            });
    }
}
export default EmployeeForm;