import React from "react";

export default function Form({ handleSubmit, setValue, value }) {
  const handleChange = (e) => {
    setValue(e.target.value);
  };

  return (
    <div>
      <form className="flex pt-2" onSubmit={handleSubmit}>
        <input type="text" name="value" placeholder="해야 할 일을 입력하세요." value={value} onChange={handleChange} className="w-full px-3 py-2 mr-4 text-gray-500 border rounded shadow" />
        <input className="p-2 text-blue-400 border-2 border-blue-400 rounded hover:text-white hover:bg-blue-200" type="submit" value={"입력"} style={{ flex: "1" }} />
      </form>
    </div>
  );
}
