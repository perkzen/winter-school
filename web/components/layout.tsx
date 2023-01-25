import React, { FC, ReactNode } from 'react';

const Layout: FC<{ children: ReactNode }> = ({ children }) => {
  return (
    <div className={'py-10 px-20 w-full h-screen bg-gray-50'}>{children}</div>
  );
};

export default Layout;
