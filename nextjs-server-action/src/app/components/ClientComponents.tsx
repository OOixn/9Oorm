import { addTodo } from "@/lib/actions";
import React from "react";

const ClientComponents = () => {
  return (
    <form action={addTodo}>
      <button type="submit">Add to Cart</button>
    </form>
  );
};

export default ClientComponents;
