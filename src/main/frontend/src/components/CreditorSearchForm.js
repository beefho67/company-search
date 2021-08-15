import React from "react";

const CreditorSearchForm = ({
  onSubmitHandler,
  searchTerm,
  onInputChange,
  error
}) => {
  return (
    <form onSubmit={onSubmitHandler}>
      <label>
        <span>Search for creditors</span>
        <input
          type="search"
          placeholder="creditor name"
          value={searchTerm}
          onChange={onInputChange}
          required
        />
        <button type="submit">Search</button>
      </label>
      {error && (
        <div style={{ color: `red` }}>
          some error occurred, while fetching api
        </div>
      )}
    </form>
  );
};

export default CreditorSearchForm;
