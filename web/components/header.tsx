import React, { FC } from 'react';

interface HeaderProps {
  title: string;
  subtitle: string;
}

const Header: FC<HeaderProps> = ({ title, subtitle }) => {
  return (
    <div className={'flex flex-row'}>
      <div className={'grow'}>
        <h1 className="text-3xl font-bold text-green-500">{title}</h1>
        <h2 className={'text-gray-600'}>{subtitle}</h2>
      </div>
      <div className={'flex items-center'}>
        <button className={'shadow-lg bg-green-500 rounded-full p-3'}>
          Naredi neke
        </button>
      </div>
    </div>
  );
};

export default Header;
