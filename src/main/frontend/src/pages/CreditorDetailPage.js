import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

import CreditorDetail from "../components/CreditorDetail";

const CreditorDetailPage = ({ match }) => {
  const {
    params: { creditorId }
  } = match;
  const [creditor, setCreditor] = useState(null);
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const API_BASE_URL = `/api/creditors`;
    const fetchCreditor = async () => {
      setLoading(true);
      setError(false);
      try {
        const result = await axios.get(`${API_BASE_URL}/${creditorId}`);
        setCreditor(result.data);
      } catch (error) {
        setError(true);
      }
      setLoading(false);
    };
    // Call the API
    fetchCreditor();
  }, [creditorId]);

  return (
    <>
      <Link to={`/`}>Go back to search creditors</Link>
      {loading && (
        <div style={{ color: `green` }}>
          loading creditor detail for creditor ID: <strong>{creditorId}</strong>
        </div>
      )}
      {error && (
        <div style={{ color: `red` }}>
          some error occurred, while fetching api
        </div>
      )}
      {creditor && <CreditorDetail creditor={creditor} />}
    </>
  );
};

export default CreditorDetailPage;
