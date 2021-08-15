import React, { useState } from "react";
import axios from "axios";

import CreditorSearchForm from "../components/CreditorSearchForm";
import Loader from "../components/loader";
import CreditorList from "../components/CreditorList";

const SearchPage = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [creditors, setCreditors] = useState([]);
  const [error, setError] = useState(false);
  const [loading, setLoading] = useState(false);

  const API_BASE_URL = `/api/creditors/search/findByCreditorNameContainingOrderByCreditorNameDesc`;

  const fetchCreditors = async () => {
    setLoading(true);
    setError(false);
    try {
      const result = await axios.get(`${API_BASE_URL}?creditorName=${searchTerm}`);
      setCreditors(result.data._embedded.creditors);
    } catch (error) {
      setError(true);
    }
    setLoading(false);
  };

  const onInputChange = e => {
    setSearchTerm(e.target.value);
  };

  const onSubmitHandler = e => {
    e.preventDefault();
    fetchCreditors();
  };

  return (
    <>
      <CreditorSearchForm
        onSubmitHandler={onSubmitHandler}
        onInputChange={onInputChange}
        searchTerm={searchTerm}
        error={error}
      />
      <Loader searchTerm={searchTerm} loading={loading} />
      <CreditorList creditors={creditors} />
    </>
  );
};

export default SearchPage;
