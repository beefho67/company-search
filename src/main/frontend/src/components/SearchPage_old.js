
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function SearchPage() {
  const [allData, setAllData] = useState([]);
  const [filteredData, setFilteredData] = useState(allData);

  const handleSearch = (event) => {
    let value = event.target.value.toLowerCase();
    let result = [];
    
    result = allData.filter((data) => {
      return data.creditorName.toLowerCase().search(value) != -1;
    });
    console.log("result: " + result);
    setFilteredData(result);
  }

  const styles = {
    display:'inline',
    width:'45%',
    height:100,
    float:'left',
    padding:5,
    border:'0.5px solid black',
    marginBottom:10,
    marginRight:10
  }

  useEffect(() => {
    axios('/api/creditors/search/findByCreditorNameContainingOrderByCreditorNameAsc?creditorName=')
    .then(response => {
      console.log(response.data._embedded.creditors);
      setAllData(response.data._embedded.creditors);
      setFilteredData(response.data._embedded.creditors);
    })
    .catch(error => {
      console.log('Error getting fake data: ' + error);
    })
  }, []);

  return (
    <div className="SearchPage">
      <div style={{ margin: '0 auto', marginTop: '10%' }}>
        <label>Search</label>
        <input type="text" onChange={(event) => handleSearch(event)} />
      </div>
      <div style={{padding:10}}>
        {filteredData.map((value,index) => {
            return(
              <div key={value.id}>
                <div style={styles}>
                  {value.creditorName}
                </div>
              </div>
            )
          }
        )}
      </div>
    </div>
  );
}

export default SearchPage;