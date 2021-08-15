import React from "react";

const CreditorDetail = ({ creditor }) => {

  return (
    <section>
      <div>
        <div>
          <h3>
            <strong>Creditor Name:</strong> {creditor.creditorName}
          </h3>
          <p>
            <strong>Attention:</strong> {creditor.attention}
          </p>
          <p>
            <strong>Address1:</strong> {creditor.address1}
          </p>
          <p>
            <strong>Address2:</strong> {creditor.address2}
          </p>
          <p>
            <strong>City:</strong> {creditor.city}
          </p>
          <p>
            <strong>State:</strong> {creditor.state}
          </p>
          <p>
            <strong>Postal Zip:</strong> {creditor.postalZip}
          </p>
        </div>
      </div>
    </section>
  );
};

export default CreditorDetail;
