import React from 'react';
import logo from './PROXIFILE-LOGO.png';
import './App.css';

import SearchPage from './Components/SearchPage.js';

function App() {
  return (
    <div className="App">
        <header className="App-header">
          <img src={logo} alt="logo" />
          <SearchPage />
      </header>

    </div>
  );
}

export default App;