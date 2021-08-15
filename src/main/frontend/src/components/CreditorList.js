import React from "react";
import { Link } from "react-router-dom";

const Creditor = ({ creditor }) => {
  return (
    <li>
      <div>
        <div>
          <h3>{creditor.creditorName}</h3>
          <p>{creditor.attention}</p>
          <p>{creditor.city}</p>
          <p>{creditor.state}</p>
          <Link to={`/creditor/${creditor.id}`}>Show details</Link>
        </div>
      </div>
      <hr />
    </li>
  );
};

const CreditorList = ({ creditors }) => {
    
  return (
    <ul>
      {creditors.map((creditor, index) => {
        return <Creditor creditor={creditor} key={index} />;
      })}
    </ul>
  );
};

export default CreditorList;
